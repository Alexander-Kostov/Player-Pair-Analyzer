package com.academy.server.dto.teams_dtos;

public class TeamWithoutPlayersDTO {
    private Long id;
    private String name;
    private String manager;
    private String groupName;

    public TeamWithoutPlayersDTO(Long id, String name, String manager, String groupName) {
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
}
