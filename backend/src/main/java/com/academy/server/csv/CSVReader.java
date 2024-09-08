package com.academy.server.csv;

import com.academy.server.model.Meet;
import com.academy.server.model.Player;
import com.academy.server.model.Team;
import com.academy.server.service.TeamService;
import com.academy.server.util.DateParser;
import com.academy.server.validation.impl.InputValidator;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CSVReader {
    @Autowired
    private InputValidator inputValidator;
    @Autowired
    private TeamService teamService;
    @Autowired
    private DateParser dateParser;
    public List<Team> readTeams(String filepath) {
        List<Team> teams = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            // We are creating and sending this value in case an error appears while reading the file.
            // It will be handy to know exactly on which line the error appears
            int lineNum = 0;

            String line;

            if ((line = br.readLine()) == null) {
                System.out.println("Teams file is empty");
                return teams;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = inputValidator.validateTeam(line, lineNum);

                if (validated) {
                    String[] data = line.split(",");
                    String country = data[1];
                    String manager = data[2];
                    String group = data[3];

                    Team team = new Team(country, manager, group);
                    teams.add(team);
                }

                lineNum++;
            }
        } catch (FileNotFoundException fileNotFoundException) {

            System.out.println(fileNotFoundException.getMessage() + "Error");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error");
        }

        return teams;
    }

    public List<Player> readPlayers(String path) {
        List<Player> players = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNum = 0;

            if ((line = br.readLine()) == null) {
                System.out.println("Players file is empty");
                return players;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = inputValidator.validatePlayer(line, lineNum);
                String[] data = line.split(",");

                if (validated) {
                    int teamNumber = Integer.parseInt(data[1]);
                    String position = data[2];
                    String name = data[3];
                    Long teamId = Long.parseLong(data[4]);
                    Team team = teamService.getTeamById(teamId).get();
                    Player player = new Player(name, teamNumber, position, team);
                    players.add(player);
                }

                lineNum++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return players;
    }

    public List<Meet> readMeets(String path) {
        List<Meet> meets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNum = 0;

            if ((line = br.readLine()) == null) {
                System.out.println("Matches file is empty");
                return meets;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = inputValidator.validateMeet(line, lineNum);

                if (validated) {
                    String[] data = line.split(",");
                    long teamAId = Long.parseLong(data[1]);
                    long teamBId = Long.parseLong(data[2]);

                    Team teamA = teamService.getTeamById(teamAId).get();
                    Team teamB = teamService.getTeamById(teamBId).get();
                    String format = "MM/dd/yyyy";

                    Date date = dateParser.parseDateFromMDY(data[3], format);

                    Meet meet = new Meet(teamA, teamB, date, data[4]);
                    meets.add(meet);
                }


                lineNum++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return meets;
    }
}
