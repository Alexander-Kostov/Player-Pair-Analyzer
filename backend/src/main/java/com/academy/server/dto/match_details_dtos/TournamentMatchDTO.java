package com.academy.server.dto.match_details_dtos;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TournamentMatchDTO {

    private Long id;
    private String teamAName;
    private Long teamAId;
    private String teamBName;
    private Long teamBId;
    private String score;
    private LocalDateTime date;

    public TournamentMatchDTO(Long id, String teamAName, Long teamAId, String teamBName, Long teamBId, String score, LocalDateTime date) {
        this.id = id;
        this.teamAName = teamAName;
        this.teamAId = teamAId;
        this.teamBName = teamBName;
        this.teamBId = teamBId;
        this.score = score;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public Long getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
