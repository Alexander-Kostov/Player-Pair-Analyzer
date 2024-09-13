package com.academy.server.service;

import com.academy.server.dto.PlayerParticipationDTO;
import com.academy.server.dto.PlayersWithMostMutualTimeDTO;
import com.academy.server.model.PlayerParticipation;
import com.academy.server.repository.PlayerParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerParticipationService {
    @Autowired
    private PlayerParticipationRepository playerParticipationRepository;

    public void saveAllParticipations(List<PlayerParticipation> playerParticipations) {
        playerParticipationRepository.saveAll(playerParticipations);
    }

    public List<PlayerParticipationDTO> getAllPlayerParticipations() {
        return playerParticipationRepository
                .findAll().stream()
                .map(this::mapToPlayerParticipationDTO)
                .collect(Collectors.toList());
    }
    public List<PlayersWithMostMutualTimeDTO> getPlayersWithMostMutualTime() {
        List<Object[]> results = playerParticipationRepository.findPlayersWithMostMutualTime();
        return mapToPlayersWithMostMutualTimeDTO(results);
    }

    public List<PlayersWithMostMutualTimeDTO> findPlayersWithMostMutualTimeFromDifferentTeams() {
        List<Object[]> playersWithMostMutualTimeFromDifferentTeams =
                playerParticipationRepository.findPlayersWithMostMutualTimeFromDifferentTeams();
        return mapToPlayersWithMostMutualTimeDTO(playersWithMostMutualTimeFromDifferentTeams);
    }

    private List<PlayersWithMostMutualTimeDTO> mapToPlayersWithMostMutualTimeDTO(List<Object[]> results) {
        List<PlayersWithMostMutualTimeDTO> resultDTOs = new ArrayList<>();
        for (Object[] result : results) {
            String player1 = (String) result[0];
            String player2 = (String) result[1];
            BigDecimal bigDecimal = (BigDecimal) result[2];
            int totalTimeTogether = bigDecimal.intValue();
            String matchTime = (String) result[3];
            resultDTOs.add(new PlayersWithMostMutualTimeDTO(player1, player2, totalTimeTogether, matchTime));
        }
        return resultDTOs;
    }

    private PlayerParticipationDTO mapToPlayerParticipationDTO(PlayerParticipation playerParticipation) {
        return new PlayerParticipationDTO(
                playerParticipation.getId(),
                playerParticipation.getPlayer().getId(),
                playerParticipation.getMeet().getId(),
                playerParticipation.getFromMinutes(),
                playerParticipation.getToMinutes()
        );
    }

}
