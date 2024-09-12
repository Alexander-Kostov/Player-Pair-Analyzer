package com.academy.server.service;

import com.academy.server.dto.match_details_dtos.*;
import com.academy.server.dto.MeetDTO;
import com.academy.server.dto.TournamentMatchDTO;
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
        List<Object[]> results = meetRepository.getMatchDetailsById(matchId);

        if (results.isEmpty()) {
            return null;
        }

        Object[] firstRow = results.get(0);
        Long teamAId = ((Long) firstRow[4]);
        String teamAName = (String) firstRow[5];
        String score = (String) firstRow[6];

        Long teamBId = null;
        String teamBName = null;
        List<PlayerDTO> playersA = new ArrayList<>();
        List<PlayerDTO> playersB = new ArrayList<>();

        for (Object[] row : results) {
            Long playerId = ((Number) row[1]).longValue();
            String playerName = (String) row[2];
            String playerPosition = (String) row[3];
            Long playerTeamId = ((Long) row[4]);

            PlayerDTO playerDTO = new PlayerDTO(playerId, playerName, playerPosition);

            if (playerTeamId.equals(teamAId)) {
                playersA.add(playerDTO);
            } else {
                teamBId = ((Long) row[4]);
                teamBName = ((String) row[5]);
                playersB.add(playerDTO);
            }

        }

        TeamADTO teamADTO = new TeamADTO(teamAId, teamAName, playersA);
        TeamBDTO teamBDTO = new TeamBDTO(teamBId, teamBName, playersB);

        return new MatchDetailDTO(matchId, teamADTO, teamBDTO, score);
    }

    public List<MatchInGroupDTO> getAllGroupMatches() {
       return this.meetRepository.findMatchesWithTeamsInSameGroup()
               .stream()
               .map(this::convertToMatchInGroupDTO)
               .collect(Collectors.toList());
    }

    private MatchInGroupDTO convertToMatchInGroupDTO(Object[] dataArr) {
        Long matchId = (Long) dataArr[0];
        String teamAName = (String) dataArr[1];
        String group = (String) dataArr[2];
        Long teamAId = (Long) dataArr[3];
        String teamBName = (String) dataArr[4];
        Long teamBId = (Long) dataArr[5];
        String score = (String) dataArr[6];

        return new MatchInGroupDTO(
                matchId, group, teamAName, teamAId, teamBName, teamBId, score
        );
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
