package com.academy.server.dto;

import java.util.Date;

public class MeetDTO {
    private Long id;
    private Long teamAId;
    private Long teamBId;
    private String date;
    private String score;

    public MeetDTO(Long id, Long teamAId, Long teamBId, String date, String score) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
