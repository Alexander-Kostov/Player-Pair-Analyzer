package com.academy.server.controller;

import com.academy.server.dto.TeamDTO;
import com.academy.server.model.Team;
import com.academy.server.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/all")
    public List<TeamDTO> showAllTeams() {


        return teamService.getAll();
    }
}
