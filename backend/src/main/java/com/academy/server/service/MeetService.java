package com.academy.server.service;

import com.academy.server.dto.MeetDTO;
import com.academy.server.dto.TournamentMatchDTO;
import com.academy.server.model.Meet;
import com.academy.server.repository.MeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeetService {
    @Autowired
    private MeetRepository meetRepository;
    @Autowired
    private TeamService teamService;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void saveMeets(List<Meet> meets) {
        meetRepository.saveAll(meets);
    }

    public List<MeetDTO> getAll() {
        return this.meetRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<TournamentMatchDTO> getAllTournamentMatches() {
        List<Object[]> allMatchesData = meetRepository.findAllMatchesData();
        List<TournamentMatchDTO> matches = new ArrayList<>();

        for (Object[] result : allMatchesData) {
            Long id = (Long) result[0];
            String teamAName = (String) result[1];
            Long teamAId = (Long) result[2];
            String teamBName = (String) result[3];
            Long teamBId = (Long) result[4];
            String score = (String) result[5];
            Timestamp date = (Timestamp) result[6];
            LocalDateTime localDate = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            TournamentMatchDTO match = new TournamentMatchDTO(id, teamAName, teamAId, teamBName, teamBId, score,
                    localDate);
            matches.add(match);
        }

        return matches;
    }



    private MeetDTO convertToDTO(Meet meet) {
       return new MeetDTO(
                meet.getId(),
                meet.getTeamA().getId(),
                meet.getTeamB().getId(),
                simpleDateFormat.format(meet.getDate()),
                meet.getScore()
        );
    }

    public Optional<Meet> findMeetById(Long meetId) {
        return meetRepository.findById(meetId);
    }
}
