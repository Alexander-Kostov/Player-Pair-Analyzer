package com.academy.server.service;

import com.academy.server.dto.PlayersWithMostMutualTimeDTO;
import com.academy.server.model.PlayerParticipation;
import com.academy.server.repository.PlayerParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerParticipationService {
    @Autowired
    private PlayerParticipationRepository playerParticipationRepository;

    public void saveAllParticipations(List<PlayerParticipation> playerParticipations) {
        playerParticipationRepository.saveAll(playerParticipations);
    }

    public List<PlayersWithMostMutualTimeDTO> getPlayersWithMostMutualTime() {
        List<Object[]> results = playerParticipationRepository.findPlayersWithMostMutualTimeTogether();
        List<PlayersWithMostMutualTimeDTO> resultDTOs = new ArrayList<>();
        for (Object[] result : results) {
            String player1 = (String) result[0];
            String player2 = (String) result[1];
            BigDecimal bigDecimal = ((BigDecimal) result[2]);
            int totalTimeTogether = bigDecimal.intValue();
            resultDTOs.add(new PlayersWithMostMutualTimeDTO(player1, player2, totalTimeTogether));
        }

        return resultDTOs;
    }
}
