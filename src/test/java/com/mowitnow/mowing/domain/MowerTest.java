package com.mowitnow.mowing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.mowitnow.mowing.domain.Instruction.*;
import static com.mowitnow.mowing.domain.Orientation.EAST;
import static com.mowitnow.mowing.domain.Orientation.NORTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerTest {
    private final Lawn LAWN = new Lawn(5, 5);

    @Test
    void execute_simple_instruction() {
        Position position = new Position(1, 1, LAWN);
        Mower mower = new Mower(position, NORTH);
        assertEquals(new Mower(new Position(1, 2, LAWN), NORTH), mower.execute(FORWARD));
    }

    @Test
    void execute_many_instructions1() {
        Position position = new Position(1, 2, LAWN);
        Mower mower = new Mower(position, NORTH);
        List<Instruction> instructions = Arrays.asList(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD);
        assertEquals(new Mower(new Position(1, 3, LAWN), NORTH), mower.execute(instructions));
    }

    @Test
    void execute_many_instructions2() {
        Position position = new Position(3, 3, LAWN);
        Mower mower = new Mower(position, EAST);
        List<Instruction> instructions = Arrays.asList(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD);
        assertEquals(new Mower(new Position(5, 1, LAWN), EAST), mower.execute(instructions));
    }
}