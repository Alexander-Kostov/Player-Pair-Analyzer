package com.academy.server.service;

import com.academy.server.dto.player_dtos.SeparatePlayerDTO;
import com.academy.server.model.Player;
import com.academy.server.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return new SeparatePlayerDTO(player.getId(), player.getFullName(), player.getTeamNumber(),
                player.getPosition(), player.getTeam().getName());

    }

    public Optional<Player> findPlayerById(Long playerId) {
        return playerRepository.findById(playerId);

    }
}
