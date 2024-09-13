package com.academy.server.controller;

import com.academy.server.dto.TeamDetailsDTO;
import com.academy.server.dto.TeamWithPlayersDTO;
import com.academy.server.dto.TeamWithoutPlayersDTO;
import com.academy.server.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/with-players")
    public List<TeamWithPlayersDTO> showAllTeams() {
        return teamService.getAll();

    }

    @GetMapping("/without-players")
    public List<TeamWithoutPlayersDTO> showTeamsWithoutPlayers() {
        return teamService.getTeamsWithoutPlayers();

    }

    @GetMapping("/{teamId}")
    public List<TeamDetailsDTO> getTeamDetails(@PathVariable Long teamId) {
        return teamService.getTeamDetails(teamId);

    }

}
