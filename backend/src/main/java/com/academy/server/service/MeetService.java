package com.academy.server.service;

import com.academy.server.dto.match_details_dtos.MatchDetailDTO;
import com.academy.server.dto.MeetDTO;
import com.academy.server.dto.match_details_dtos.PlayerDTO;
import com.academy.server.dto.TournamentMatchDTO;
import com.academy.server.dto.match_details_dtos.TeamADTO;
import com.academy.server.dto.match_details_dtos.TeamBDTO;
import com.academy.server.model.Meet;
import com.academy.server.model.Player;
import com.academy.server.model.Team;
import com.academy.server.repository.MeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    @Autowired
    private PlayerService playerService;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void saveMeets(List<Meet> meets) {
        meetRepository.saveAll(meets);
    }

    public List<MeetDTO> getAll() {
        return this.meetRepository.findAll().stream().map(this::convertToMeetDTO).collect(Collectors.toList());
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

    public MatchDetailDTO getMatchDetails(Long matchId) {
        // Получаване на информация за срещата
        Meet meet = meetRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        Team teamB = teamService.getTeamById(meet.getTeamA().getId())
                .orElseThrow(() -> new RuntimeException("Team B not found"));

        Team teamA = teamService.getTeamById(meet.getTeamB().getId())
                .orElseThrow(() -> new RuntimeException("Team A not found"));

        List<PlayerDTO> teamAplayers = teamA.getPlayers()
                .stream()
                .map(this::convertPlayerToPlayerDTO)
                .collect(Collectors.toList());

        List<PlayerDTO> teamBplayers = teamB.getPlayers()
                .stream()
                .map(this::convertPlayerToPlayerDTO)
                .collect(Collectors.toList());

        TeamADTO teamADTO = new TeamADTO(teamA.getId(), teamA.getName(), teamAplayers);
        TeamBDTO teamBDTO = new TeamBDTO(teamB.getId(), teamB.getName(), teamBplayers);

        // Създаване на DTO с комбинираните данни
        MatchDetailDTO matchDetailDTO = new MatchDetailDTO(
                meet.getId(),
                teamADTO,
                teamBDTO,
                meet.getScore()
        );

        return matchDetailDTO;
    }

    private PlayerDTO convertPlayerToPlayerDTO(Player player) {
        return new PlayerDTO(player.getId(), player.getFullName(), player.getPosition());
    }
    private MeetDTO convertToMeetDTO(Meet meet) {
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
