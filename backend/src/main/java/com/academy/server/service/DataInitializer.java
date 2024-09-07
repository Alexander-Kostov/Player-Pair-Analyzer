package com.academy.server.service;

import com.academy.server.csv.CSVReader;
import com.academy.server.model.Player;
import com.academy.server.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private CSVReader csvReader;

    @PostConstruct
    public void init() {
        loadData();
    }

    private void loadData() {
        String filepath = "src/main/java/com/academy/server/data";

        List<Team> teams = csvReader.readTeams(filepath + "/teams.csv");
        teamService.saveTeams(teams);

        List<Player> players = csvReader.readPlayers(filepath + "/players.csv");
        playerService.savePlayers(players);
    }


}
