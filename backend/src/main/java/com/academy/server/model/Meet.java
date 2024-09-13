package com.academy.server.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Meet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_a_id", nullable = false)
    private Team teamA;

    @ManyToOne
    @JoinColumn(name = "team_b_id", nullable = false)
    private Team teamB;

    private Date date;

    private String score;

    public Meet() {}

    public Meet(Team teamA, Team teamB, Date date, String score) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }
}
