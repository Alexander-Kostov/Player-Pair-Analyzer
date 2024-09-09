package com.academy.server.dto;

public class PlayerParticipationDTO {
    private long id;
    private long playerId;
    private long meetId;
    private int fromMinutes;
    private int toMinutes;
    public PlayerParticipationDTO(long id, long playerId, long meetId, int fromMinutes, int toMinutes) {
        this.id = id;
        this.playerId = playerId;
        this.meetId = meetId;
        this.fromMinutes = fromMinutes;
        this.toMinutes = toMinutes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getMeetId() {
        return meetId;
    }

    public void setMeetId(long meetId) {
        this.meetId = meetId;
    }

    public int getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(int fromMinutes) {
        this.fromMinutes = fromMinutes;
    }

    public int getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(int toMinutes) {
        this.toMinutes = toMinutes;
    }
}
