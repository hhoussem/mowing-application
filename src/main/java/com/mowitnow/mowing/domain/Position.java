package com.mowitnow.mowing.domain;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private final Lawn lawn;

    public Position(int x, int y, Lawn lawn) {
        this.x = x;
        this.y = y;
        this.lawn = lawn;
    }

    public Position up() {
        this.y = (this.y + 1 <= this.lawn.getWidth()) ? ++this.y : this.y;
        return this;
    }

    public Position down() {
        this.y = (this.y - 1 >= 0) ? --this.y : this.y;
        return this;
    }

    public Position right() {
        this.x = (this.x + 1 <= this.lawn.getLength()) ? ++this.x : this.x;
        return this;
    }

    public Position left() {
        this.x = (this.x - 1 >= 0) ? --this.x : this.x;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}