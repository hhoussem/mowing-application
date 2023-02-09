package com.mowitnow.mowing.domain;

public class Mower {
    private int xPosition;

    private int yPosition;

    private Orientation orientation;

    public Mower(int xPosition, int yPosition, Orientation orientation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientation = orientation;
    }
}
