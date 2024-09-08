package com.academy.server.validation.impl;

import com.academy.server.model.Meet;
import com.academy.server.model.Player;
import com.academy.server.model.Team;
import com.academy.server.service.MeetService;
import com.academy.server.service.PlayerService;
import com.academy.server.service.TeamService;
import com.academy.server.util.DateParser;
import com.academy.server.validation.Validation;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
public class InputValidator implements Validation {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MeetService meetService;
    @Autowired
    private DateParser dateParser;

    @Override
    public boolean validateTeam(String line, int lineNum) {
        String[] data = line.split(",");

        if (data.length != 4) {
            System.out.println("Invalid number of parameters at line " + lineNum);
            return false;
        }

        String country = data[1];
        String manager = data[2];
        String group = data[3];

        if (checkIfStringIsNull(country)) {
            System.out.println("Country is null or empty at line " + lineNum);
            return false;
        }

        if (checkIfStringIsNull(manager)) {
            System.out.println("Manager is null or empty at line " + lineNum);
            return false;
        }

        if (checkIfStringIsNull(group)) {
            System.out.println("Group is null or empty at line " + lineNum);
            return false;
        }

        return true;
    }

    @Override
    public boolean validatePlayer(String line, int lineNum) {
        String[] data = line.split(",");

        if (data.length != 5) {
            System.out.println("Invalid number of parameters at line " + lineNum);
            return false;
        }

        try {
            int teamNumber = Integer.parseInt(data[1]);

            if (checkIfStringIsNull(data[2])) {
                System.out.println("Position is null or empty at line " + lineNum);
                return false;
            }

            if (checkIfStringIsNull(data[3])) {
                System.out.println("Name is null or empty at line " + lineNum);
                return false;
            }

            Long teamId = Long.parseLong(data[4]);

            Optional<Team> optionalTeam = teamService.getTeamById(teamId);

            if (optionalTeam.isEmpty()) {
                System.out.println("There is no such team for player at line " + lineNum);
                return false;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number at line " + lineNum);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateMeet(String line, int lineNum) {
        String[] data = line.split(",");

        if (data.length != 5) {
            System.out.println("Invalid number of parameters at line " + lineNum);
            return false;
        }

        try {
            long teamAId = Long.parseLong(data[1]);
            long teamBId = Long.parseLong(data[2]);

            Optional<Team> teamAById = teamService.getTeamById(teamAId);
            Optional<Team> teamBById = teamService.getTeamById(teamBId);

            if (teamAById.isEmpty()) {
                System.out.println("There is no such team at line " + lineNum);
                return false;
            }

            if (teamBById.isEmpty()) {
                System.out.println("There is no such team at line " + lineNum);
                return false;
            }

            String format = "MM/dd/yyyy";
            Date date = dateParser.parseDateFromMDY(data[3], format);

            if (date == null) {
                System.out.println("Invalid date parse at line " + lineNum);
                return false;
            }

            String resultString = data[4].trim();

            if (!isValidResultFormat(resultString)) {
                System.out.println("Invalid result format at line " + lineNum);
                return false;
            }



        } catch (NumberFormatException e) {
            System.out.println("Invalid number at line " + lineNum);
            return false;
        }

        return true;
    }

    @Override
    public boolean validateParticipation(String line, int lineNum) {
        String[] data = line.split(",");
        if (data.length != 5) {
            System.out.println("Invalid number of parameters at line " + lineNum);
            return false;
        }

        try {
            Long playerId = Long.parseLong(data[1]);
            Optional<Player> playerById = playerService.findPlayerById(playerId);
            if (playerById.isEmpty()) {
                System.out.println("Player with id " + playerId + " does not exist at line " + lineNum);
                return false;
            }

            Long meetId = Long.parseLong(data[2]);
            Optional<Meet> meetById = meetService.findMeetById(meetId);
            if (meetById.isEmpty()) {
                System.out.println("There is no such match with id " + meetById + " at line" + lineNum);
                return false;
            }

            int fromMinutes = Integer.parseInt(data[3]);

            if (fromMinutes < 0) {
                System.out.println("From minutes cannot be negative number at line " + lineNum);
            }

            String toMinutes = data[4].trim();

            if (!toMinutes.equals("NULL")) {
                Integer.parseInt(toMinutes);
            }

            if (toMinutes.equals("NULL")) {
                int toMinutesInNumber = 90;
                if (fromMinutes >= toMinutesInNumber) {
                    System.out.println("Invalid player participation time: fromMinutes cannot be greater than or " +
                            "equal to toMinutes at line " + lineNum);
                    return false;
                }
            } else {
                int toMinutesInNumber = Integer.parseInt(toMinutes);
                if (fromMinutes >= toMinutesInNumber) {
                    System.out.println("Invalid player participation time: fromMinutes cannot be greater than or equal to toMinutes at line " + lineNum);
                    return false;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number at line " + lineNum);
        }

        return true;
    }


    private boolean checkIfStringIsNull(String data) {
        return data == null || data.isBlank();
    }

    private boolean isValidResultFormat(String result) {
        if (result.matches("\\d{1,2}-\\d{1,2}")) {
            return true;
        }

        return result.matches("\\d{1,2}\\(\\d{1,2}\\)-\\d{1,2}\\(\\d{1,2}\\)");
    }
}
