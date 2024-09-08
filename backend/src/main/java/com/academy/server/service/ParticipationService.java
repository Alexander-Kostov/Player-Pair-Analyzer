package com.academy.server.service;

import com.academy.server.model.Participation;
import com.academy.server.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository participationRepository;

    public void saveAllParticipations(List<Participation> participations) {
        participationRepository.saveAll(participations);
    }
}
