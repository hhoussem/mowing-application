package com.mowitnow.mowing.domain;

import static com.mowitnow.mowing.domain.Instruction.LEFT;
import static com.mowitnow.mowing.domain.Instruction.RIGHT;
import static java.util.Arrays.stream;

public enum Orientation {
    NORTH('N', 0),
    EAST('E', 90),
    SOUTH('S', 180),
    WEST('W', 270);

    private final char abbreviation;
    private final int angle;
    private static final int FULL_ANGLE = 360;
    private static final int RIGHT_ANGLE = 90;

    Orientation(char abbreviation, int angle) {
        this.abbreviation = abbreviation;
        this.angle = angle;
    }

    Orientation turn(Instruction instruction) {
        if (instruction.equals(RIGHT)) {
            return getOrientationByAngle((this.angle + RIGHT_ANGLE) % FULL_ANGLE);
        }
        if (instruction.equals(LEFT)) {
            return getOrientationByAngle((FULL_ANGLE + this.angle - RIGHT_ANGLE) % FULL_ANGLE);
        }
        return this;

    }

    public static Orientation of(char abbreviation) {
        return stream(values())
                .filter(o -> o.abbreviation == abbreviation)
                .findFirst()
                .orElseThrow();
    }

    private Orientation getOrientationByAngle(int angle) {
        return stream(values()).filter(o -> o.angle == angle).findFirst().orElseThrow(
                () -> new IllegalArgumentException("Can not determine orientation of the angle: " + angle));
    }


}
