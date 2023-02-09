package com.mowitnow.mowing.domain;

public class Mower {
    private Position position;

    private Orientation orientation;

    public Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }
}
