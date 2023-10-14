package com.mowitnow.mowing.domain;

import static java.util.Arrays.stream;

public enum Instruction {
    FORWARD('A'),
    RIGHT('D'),
    LEFT('G');

    private final char abbreviation;

    Instruction(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Instruction of(char abbreviation) {
        return stream(values())
                .filter(o -> o.abbreviation == abbreviation)
                .findFirst()
                .orElseThrow();
    }
}
