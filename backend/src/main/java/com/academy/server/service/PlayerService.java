package com.academy.server.service;

import com.academy.server.dto.PlayerInTeamDTO;
import com.academy.server.dto.SeparatePlayerDTO;
import com.academy.server.dto.TeamDTO;
import com.academy.server.model.Player;
import com.academy.server.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void savePlayers(List<Player> players) {
        playerRepository.saveAll(players);
    }

    public List<SeparatePlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private SeparatePlayerDTO convertToDTO(Player player) {
        TeamDTO team = new TeamDTO(
                player.getTeam().getId(),
                player.getTeam().getName(),
                player.getTeam().getManager(),
                player.getTeam().getGroupName()
        );

        return new SeparatePlayerDTO(player.getId(), player.getFullName(), player.getTeamNumber(),
                player.getPosition(), player.getTeam().getId());

    }
}
