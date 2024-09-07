package com.academy.server.service;

import com.academy.server.csv.CSVReader;
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
    private CSVReader csvReader;

    @PostConstruct
    public void init() {
        loadData();
    }

    private void loadData() {
        List<Team> teams = csvReader.readTeams("src/main/java/com/academy/server/data/teams.csv");
        teamService.save(teams);
    }


}
