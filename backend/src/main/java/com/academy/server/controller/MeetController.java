package com.academy.server.controller;

import com.academy.server.dto.MeetDTO;
import com.academy.server.dto.TournamentMatchDTO;
import com.academy.server.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meets")
@CrossOrigin(origins = "http://localhost:5173")
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

}
