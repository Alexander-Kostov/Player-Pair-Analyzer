package com.academy.server.service;

import com.academy.server.model.Team;
import com.academy.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }
}
