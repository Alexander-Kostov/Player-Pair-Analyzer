package com.academy.server.controller;

import com.academy.server.dto.PlayersWithMostMutualTimeDTO;
import com.academy.server.service.PlayerParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/participations")
public class PlayerParticipationController {
    @Autowired
    private PlayerParticipationService participationService;
    @GetMapping("/most-time")
    public List<PlayersWithMostMutualTimeDTO> showPlayersWithMostMutualTime() {
        return participationService.getPlayersWithMostMutualTime();
    }
}
