package com.academy.server.dto.match_details_dtos;

public class MatchDetailDTO {

    private Long matchId;
    private TeamADTO teamADTO;
    private TeamBDTO teamBDTO;
    private String score;

    public MatchDetailDTO(Long matchId, TeamADTO teamADTO, TeamBDTO teamBDTO, String score) {
        this.matchId = matchId;
        this.teamADTO = teamADTO;
        this.teamBDTO = teamBDTO;
        this.score = score;
    }
    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public TeamADTO getTeamADTO() {
        return teamADTO;
    }

    public void setTeamADTO(TeamADTO teamADTO) {
        this.teamADTO = teamADTO;
    }

    public TeamBDTO getTeamBDTO() {
        return teamBDTO;
    }

    public void setTeamBDTO(TeamBDTO teamBDTO) {
        this.teamBDTO = teamBDTO;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
