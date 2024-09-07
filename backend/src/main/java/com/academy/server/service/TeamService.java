package com.academy.server.service;

import com.academy.server.model.Team;
import com.academy.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public void saveTeams(List<Team> teams) {
        teamRepository.saveAllAndFlush(teams);

    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }
}
