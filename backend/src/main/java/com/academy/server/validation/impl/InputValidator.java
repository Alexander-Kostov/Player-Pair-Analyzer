package com.academy.server.validation.impl;

import com.academy.server.validation.Validation;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class InputValidator implements Validation {
    @Override
    public boolean validateTeam(String line, int lineNum) {
        String[] data = line.split(",");

        if (data.length != 4) {
            System.out.println("Invalid number of parameters at line " + lineNum);
            return false;
        }

        String country = data[1];
        String manager = data[2];
        String group = data[3];

        if (checkIfStringIsNull(country)) {
            System.out.println("Country is null at line " + lineNum);
            return false;
        }

        if (checkIfStringIsNull(manager)) {
            System.out.println("Manager is null at line " + lineNum);
            return false;
        }

        if (checkIfStringIsNull(group)) {
            System.out.println("Group is null at line " + lineNum);
            return false;
        }

        return true;
    }


    private boolean checkIfStringIsNull(String data) {
        return data == null || data.isEmpty();
    }
}
