package com.mowitnow.mowing.domain;

import java.util.Map;

import static com.mowitnow.mowing.domain.Instruction.FORWARD;
import static com.mowitnow.mowing.domain.Instruction.LEFT;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char abbreviation;

    private final static Map<Orientation, Map<Instruction, Orientation>> INSTRUCTIONS_MAPPING = Map.of(NORTH, Map.of(LEFT, WEST),
            EAST, Map.of(LEFT, NORTH),
            SOUTH, Map.of(LEFT, EAST),
            WEST, Map.of(LEFT, SOUTH));

    Orientation(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    Orientation turn(Instruction instruction) {
        return FORWARD.equals(instruction) ? this : INSTRUCTIONS_MAPPING.get(this).get(instruction);
    }
}
