package com.academy.server.controller;

import com.academy.server.dto.match_details_dtos.MatchDetailDTO;
import com.academy.server.dto.MeetDTO;
import com.academy.server.dto.TournamentMatchDTO;
import com.academy.server.dto.match_details_dtos.MatchInGroupDTO;
import com.academy.server.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meets")
public class MeetController {

    @Autowired
    private MeetService meetService;

    @GetMapping("/all")
    public List<MeetDTO> showAllMeets() {
        return meetService.getAll();

    }

    @GetMapping("/tournament-data")
    public List<TournamentMatchDTO> showAllTournamentMatches() {
        return  meetService.getAllTournamentMatches();

    }

    @GetMapping("/group-data")
    public List<MatchInGroupDTO> showAllGroupMatches() {
        return meetService.getAllGroupMatches();

    }

    @GetMapping("/{matchId}/details")
    public MatchDetailDTO getMatchDetails(@PathVariable Long matchId) {
        return meetService.getMatchDetails(matchId);

    }



}
