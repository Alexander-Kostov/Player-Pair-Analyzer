package com.academy.server.model;

import jakarta.persistence.*;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Meet meet;

    private int fromMinutes;

    private int toMinutes;

    public Participation() {
    }

    public Participation(Player player, Meet meet, int fromMinutes, int toMinutes) {
        this.player = player;
        this.meet = meet;
        this.fromMinutes = fromMinutes;
        this.toMinutes = toMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Meet getGame() {
        return meet;
    }

    public void setGame(Meet meet) {
        this.meet = meet;
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
