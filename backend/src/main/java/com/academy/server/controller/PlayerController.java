package com.academy.server.controller;

import com.academy.server.dto.PlayerInTeamDTO;
import com.academy.server.dto.SeparatePlayerDTO;
import com.academy.server.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public List<SeparatePlayerDTO> showAllPlayers() {
        return playerService.getAllPlayers();
    }
}
