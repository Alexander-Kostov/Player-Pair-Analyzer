package com.academy.server.controller;

import com.academy.server.dto.PlayerParticipationDTO;
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

    @GetMapping("/all-time")
    public List<PlayersWithMostMutualTimeDTO> showPlayersWithMostMutualTime() {
        return participationService.getPlayersWithMostMutualTime();

    }

    @GetMapping("/different-teams-time")
    public List<PlayersWithMostMutualTimeDTO> findPlayersWithMostMutualTimeFromDifferentTeams() {
        return participationService.findPlayersWithMostMutualTimeFromDifferentTeams();

    }

    @GetMapping("/all")
    public List<PlayerParticipationDTO> showAllPlayerParticipations() {
        return participationService.getAllPlayerParticipations();

    }
}
