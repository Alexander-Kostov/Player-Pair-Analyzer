package com.academy.server.dto.match_details_dtos;

public class MatchInGroupDTO {
    private Long id;
    private String group;
    private String teamAName;
    private Long teamAId;
    private String teamBName;
    private Long teamBId;
    private String score;

    public MatchInGroupDTO(Long id, String group, String teamAName, Long teamAId, String teamBName, Long teamBId,
                           String score) {
        this.id = id;
        this.group = group;
        this.teamAName = teamAName;
        this.teamAId = teamAId;
        this.teamBName = teamBName;
        this.teamBId = teamBId;
        this.score = score;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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
}
