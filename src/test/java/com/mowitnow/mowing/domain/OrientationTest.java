package com.mowitnow.mowing.domain;

import org.junit.jupiter.api.Test;

import static com.mowitnow.mowing.domain.Instruction.FORWARD;
import static com.mowitnow.mowing.domain.Instruction.LEFT;
import static com.mowitnow.mowing.domain.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrientationTest {

    @Test
    void orientation_should_not_change_when_instruction_is_forward() {
        assertEquals(NORTH, NORTH.turn(FORWARD));
        assertEquals(SOUTH, SOUTH.turn(FORWARD));
        assertEquals(EAST, EAST.turn(FORWARD));
        assertEquals(WEST, WEST.turn(FORWARD));
    }

    @Test
    void orientation_turn_left() {
        assertEquals(WEST, NORTH.turn(LEFT));
        assertEquals(EAST, SOUTH.turn(LEFT));
        assertEquals(NORTH, EAST.turn(LEFT));
        assertEquals(SOUTH, WEST.turn(LEFT));
    }
}