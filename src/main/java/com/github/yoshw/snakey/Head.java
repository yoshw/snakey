package com.github.yoshw.snakey;

/**
 * Created by yosh on 20/11/15.
 */
public class Head extends Segment {
    public Head(Cell loc) {
        super(loc);
    }

    public Head(Cell loc, Direction dir) {
        super(loc, dir);
    }

    /**
     * Assumes that the neighbour square is empty!
     */
    public void move() {
        location.setOccupant(null);
        location = location.neighbour(dir);
        location.setOccupant(this);
    }

    public void faceUp() {
        if (dir != Direction.DOWN) {
            dir = Direction.UP;
        }
    }

    public void faceRight() {
        if (dir != Direction.LEFT) {
            dir = Direction.RIGHT;
        }
    }

    public void faceDown() {
        if (dir != Direction.UP) {
            dir = Direction.DOWN;
        }
    }

    public void faceLeft() {
        if (dir != Direction.RIGHT) {
            dir = Direction.LEFT;
        }
    }
}
