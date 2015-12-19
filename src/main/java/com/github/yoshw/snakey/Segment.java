package com.github.yoshw.snakey;

/**
 * Created by Yosh on 15/11/2015.
 */
public abstract class Segment extends GameObject {
    protected Direction dir;

    public Segment(Cell loc) {
        super(loc);
        this.dir = Direction.RIGHT;
    }

    public Segment(Cell loc, Direction dir) {
        super(loc);
        this.dir = dir;
    }

    public abstract void move();

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Cell getLocation() {
        return location;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String toString() {
        return "#";
    }
}
