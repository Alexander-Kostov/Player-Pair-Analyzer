package com.academy.server.validation;

public interface Validation {
    boolean validateTeam(String line, int lineNum);

    boolean validatePlayer(String line, int lineNum);

    boolean validateMeet(String line, int lineNum);

    boolean validateParticipation(String line, int lineNum);
}
