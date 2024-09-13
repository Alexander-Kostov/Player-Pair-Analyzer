package com.academy.server.dto;

public class SeparatePlayerDTO {
    private Long id;
    private String fullName;
    private int teamNumber;
    private String position;
    private String teamName;

    public SeparatePlayerDTO(Long id, String fullName, int teamNumber, String position, String teamName) {
        this.id = id;
        this.fullName = fullName;
        this.teamNumber = teamNumber;
        this.position = position;
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
