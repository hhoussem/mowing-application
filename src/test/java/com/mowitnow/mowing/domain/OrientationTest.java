package com.mowitnow.mowing.domain;

import org.junit.jupiter.api.Test;

import static com.mowitnow.mowing.domain.Instruction.*;
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

    @Test
    void orientation_turn_right() {
        assertEquals(EAST, NORTH.turn(RIGHT));
        assertEquals(WEST, SOUTH.turn(RIGHT));
        assertEquals(SOUTH, EAST.turn(RIGHT));
        assertEquals(NORTH, WEST.turn(RIGHT));
    }
}