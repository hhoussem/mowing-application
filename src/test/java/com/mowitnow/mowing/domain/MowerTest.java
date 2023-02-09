package com.mowitnow.mowing.domain;

import org.junit.jupiter.api.Test;

import static com.mowitnow.mowing.domain.Instruction.FORWARD;
import static com.mowitnow.mowing.domain.Orientation.NORTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerTest {
    // TODO: 09/02/2023 create Lawn fixture
    public static final int LAWN_LENGTH = 5;
    public static final int LAWN_WIDTH = 4;
    private final Lawn LAWN = new Lawn(LAWN_LENGTH, LAWN_WIDTH);

    @Test
    void execute() {
        Position position = new Position(1, 1, LAWN);
        Mower mower = new Mower(position, NORTH);
        assertEquals(new Mower(new Position(1, 2, LAWN), NORTH), mower.execute(FORWARD));
    }
}