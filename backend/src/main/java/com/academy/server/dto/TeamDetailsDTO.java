package com.academy.server.dto;

public class TeamDetailsDTO {
    private Long id;
    private String teamName;
    private Integer playerNumber;
    private String playerName;
    private String playerPosition;

    public TeamDetailsDTO(Long id, String teamName, Integer playerNumber, String playerName, String playerPosition) {
        this.id = id;
        this.teamName = teamName;
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
}
