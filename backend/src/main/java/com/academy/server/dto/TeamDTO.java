package com.academy.server.dto;

import java.util.List;

public class TeamDTO {
    private Long id;
    private String name;
    private String manager;
    private String groupName;
    private List<PlayerInTeamDTO> players;

    public TeamDTO(Long id, String name, String manager, String groupName, List<PlayerInTeamDTO> players) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.groupName = groupName;
        this.players = players;
    }

    public TeamDTO(Long id, String name, String manager, String groupName) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<PlayerInTeamDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerInTeamDTO> players) {
        this.players = players;
    }
}
