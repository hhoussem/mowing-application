package com.mowitnow.mowing.domain;

import java.util.Map;

import static com.mowitnow.mowing.domain.Instruction.*;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char abbreviation;

    private final static Map<Orientation, Map<Instruction, Orientation>> INSTRUCTIONS_MAPPING = Map.of(NORTH, Map.of(LEFT, WEST, RIGHT, EAST),
            EAST, Map.of(LEFT, NORTH, RIGHT, SOUTH),
            SOUTH, Map.of(LEFT, EAST, RIGHT, WEST),
            WEST, Map.of(LEFT, SOUTH, RIGHT, NORTH));

    Orientation(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    Orientation turn(Instruction instruction) {
        return FORWARD.equals(instruction) ? this : INSTRUCTIONS_MAPPING.get(this).get(instruction);
    }
}
