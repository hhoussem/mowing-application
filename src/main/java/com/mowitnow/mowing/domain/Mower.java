package com.mowitnow.mowing.domain;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.mowitnow.mowing.domain.Instruction.FORWARD;
import static com.mowitnow.mowing.domain.Orientation.*;

public class Mower {
    private Position position;

    private Orientation orientation;

    private final Map<Orientation, Function<Position, Position>> FORWARD_ORIENTATIONS = Map.of(NORTH, Position::up,
            EAST, Position::right,
            SOUTH, Position::down,
            WEST, Position::left);

    public Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Mower execute(Instruction instruction) {
        if (FORWARD.equals(instruction)) {
            this.position = this.forward();
        } else {
            this.orientation = this.orientation.turn(instruction);
        }
        return this;
    }

    private Position forward() {
        return FORWARD_ORIENTATIONS.get(this.orientation).apply(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) && orientation == mower.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", orientation=" + orientation +
                '}';
    }
}
