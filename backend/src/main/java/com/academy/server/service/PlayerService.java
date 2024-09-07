package com.academy.server.service;

import com.academy.server.model.Player;
import com.academy.server.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void savePlayers(List<Player> players) {
        playerRepository.saveAll(players);
    }
}
