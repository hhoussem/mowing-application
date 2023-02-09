package com.mowitnow.mowing.domain;

import static com.mowitnow.mowing.domain.Instruction.FORWARD;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char abbreviation;

    Orientation(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    Orientation turn(Instruction instruction) {
        return FORWARD.equals(instruction) ? this : null;
    }
}
