package com.academy.server.service;

import com.academy.server.dto.PlayerInTeamDTO;
import com.academy.server.dto.TeamWithPlayersDTO;
import com.academy.server.dto.TeamWithoutPlayersDTO;
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

    public List<TeamWithPlayersDTO> getAll() {
        return teamRepository.findAll()
                .stream()
                .map(this::convertToDTOWithPlayers)
                .collect(Collectors.toList());
    }

    public void saveTeams(List<Team> teams) {
        teamRepository.saveAll(teams);
    }

    public Optional<Team> getTeamById(Long id) {

        return teamRepository.findById(id);
    }

    public List<TeamWithoutPlayersDTO> getTeamsWithoutPlayers() {
        return this.teamRepository.findAll()
                .stream()
                .map(this::convertToDTOWithoutPlayers)
                .collect(Collectors.toList());
    }

    private TeamWithoutPlayersDTO convertToDTOWithoutPlayers(Team team) {
        return new TeamWithoutPlayersDTO(
                team.getId(),
                team.getName(),
                team.getManager(),
                team.getGroupName()
        );
    }

    private TeamWithPlayersDTO convertToDTOWithPlayers(Team team) {
        List<PlayerInTeamDTO> playerInTeamDTOS = team.getPlayers().stream()
                .map(player -> new PlayerInTeamDTO(
                        player.getId(),
                        player.getFullName(),
                        player.getTeamNumber(),
                        player.getPosition()
                ))
                .collect(Collectors.toList());

        return new TeamWithPlayersDTO(
                team.getId(),
                team.getName(),
                team.getManager(),
                team.getGroupName(),
                playerInTeamDTOS
                );
    }


}
