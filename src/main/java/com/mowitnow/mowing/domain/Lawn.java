package com.mowitnow.mowing.domain;

public class Lawn {
    //x
    private final int length;
    //y
    private final int width;

    public Lawn(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
