package com.academy.server.dto.participations_dtos;

public class PlayersWithMostMutualTimeDTO {
    private String player1;
    private String player2;
    private int totalTimeTogether;
    private String matchTimes;

    public PlayersWithMostMutualTimeDTO(String player1, String player2, int totalTimeTogether, String matchTimes) {
        this.player1 = player1;
        this.player2 = player2;
        this.totalTimeTogether = totalTimeTogether;
        this.matchTimes = matchTimes;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getTotalTimeTogether() {
        return totalTimeTogether;
    }

    public void setTotalTimeTogether(int totalTimeTogether) {
        this.totalTimeTogether = totalTimeTogether;
    }

    public String getMatchTimes() {
        return matchTimes;
    }

    public void setMatchTimes(String matchTimes) {
        this.matchTimes = matchTimes;
    }
}