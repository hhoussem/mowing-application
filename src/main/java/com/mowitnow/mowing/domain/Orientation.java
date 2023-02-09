package com.mowitnow.mowing.domain;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char abbreviation;

    Orientation(char abbreviation) {
        this.abbreviation = abbreviation;
    }
}
