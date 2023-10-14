package com.mowitnow.mowing.domain;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;
    private final Lawn lawn;

    public Position(int x, int y, Lawn lawn) {
        this.x = x;
        this.y = y;
        this.lawn = lawn;
    }

    public Position up() {
        if (this.y + 1 <= this.lawn.getWidth()) {
            return new Position(this.x, this.y + 1, this.lawn);
        }
        return this;
    }

    public Position down() {
        if (this.y - 1 >= 0) {
            return new Position(this.x, this.y - 1, this.lawn);
        }
        return this;
    }

    public Position right() {
        if (this.x + 1 <= this.lawn.getLength()) {
            return new Position(this.x + 1, this.y, this.lawn);
        }
        return this;
    }

    public Position left() {
        if (this.x - 1 >= 0) {
            return new Position(this.x - 1, this.y, this.lawn);
        }
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && lawn.equals(position.lawn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, lawn);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}