package com.mowitnow.mowing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    public static final int LAWN_LENGTH = 5;
    public static final int LAWN_WIDTH = 4;
    private final Lawn LAWN = new Lawn(LAWN_LENGTH, LAWN_WIDTH);

    @Test
    void position_can_go_up() {
        Position position = new Position(0, 0, LAWN);
        assertEquals(new Position(0, 1, LAWN), position.up());
    }

    @Test
    void up_position_is_the_same_when_it_is_on_top_of_lawn() {
        Position position = new Position(1, LAWN_WIDTH, LAWN);
        assertEquals(position, position.up());
    }

    @Test
    void position_can_go_down() {
        Position position = new Position(0, 3, LAWN);
        assertEquals(new Position(0, 2, LAWN), position.down());
    }

    @Test
    void down_position_is_the_same_when_it_is_on_bottom_of_lawn() {
        Position position = new Position(1, 0, LAWN);
        assertEquals(position, position.down());
    }

    @Test
    void position_can_go_right() {
        Position position = new Position(3, 4, LAWN);
        assertEquals(new Position(4, 4, LAWN), position.right());
    }

    @Test
    void right_position_is_the_same_when_it_is_on_right_limit_of_lawn() {
        Position position = new Position(LAWN_LENGTH, 2, LAWN);
        assertEquals(position, position.right());
    }

    @Test
    void position_can_go_left() {
        Position position = new Position(3, 4, LAWN);
        assertEquals(new Position(2, 4, LAWN), position.left());
    }

    @Test
    void left_position_is_the_same_when_it_is_on_left_limit_of_lawn() {
        Position position = new Position(0, 2, LAWN);
        assertEquals(position, position.left());
    }
}