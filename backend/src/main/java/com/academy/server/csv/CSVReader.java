package com.academy.server.csv;

import com.academy.server.model.Team;
import com.academy.server.service.TeamService;
import com.academy.server.validation.impl.InputValidator;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReader {
    @Autowired
    private InputValidator inputValidator;

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
}
