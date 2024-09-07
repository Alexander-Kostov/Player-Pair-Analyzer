package com.academy.server.service;

import com.academy.server.dto.PlayerDTO;
import com.academy.server.dto.TeamDTO;
import com.academy.server.model.Team;
import com.academy.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDTO> getAll() {
        return teamRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void saveTeams(List<Team> teams) {
        teamRepository.saveAllAndFlush(teams);
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    private TeamDTO convertToDTO(Team team) {
        List<PlayerDTO> playerDTOs = team.getPlayers().stream()
                .map(player -> new PlayerDTO(
                        player.getId(),
                        player.getFullName(),
                        player.getTeamNumber(),
                        player.getPosition()
                ))
                .collect(Collectors.toList());

        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getManager(),
                team.getGroupName(),
                playerDTOs
                );
    }
}
