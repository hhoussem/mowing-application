package com.mowitnow.mowing.domain;

public enum Instruction {
    FORWARD('A'),
    RIGHT('D'),
    LEFT('G');

    private final char abbreviation;

    Instruction(char abbreviation) {
        this.abbreviation = abbreviation;
    }
}
