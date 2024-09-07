package com.academy.server.model;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private int teamNumber;
    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
