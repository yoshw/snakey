package com.github.yoshw.snakey;

import java.util.ArrayList;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Segment extends GameObject {
    private Direction dir;
    private Segment leader;
    private Cell leaderLoc;

    public Segment(Cell loc) {
        super(loc);
        this.dir = Direction.RIGHT;
    }

    public Segment(Cell loc, Direction dir) {
        super(loc);
        this.dir = dir;
    }

    public Segment(Cell loc, Direction dir, Segment leader) {
        super(loc);
        this.dir = dir;
        this.leader = leader;
        leaderLoc = leader.getLocation();
    }

    public void updateDir() {
        if (!this.isHead()) {
            this.dir = this.leader.getDir();
        }
    }

    public void move() {
        location.setOccupant(null);
        if (this.isHead()) {
            location = location.requestMove(dir);
        } else {
            location = leaderLoc;
            leaderLoc = leader.getLocation();
        }
        location.setOccupant(this);
    }

    public boolean isHead() {
        return this.leader == null;
    }

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
    public String toString() {
        return "#";
    }

    public void faceUp() {
        if (dir == Direction.RIGHT || dir == Direction.LEFT) {
            dir = Direction.UP;
        }
    }

    public void faceRight() {
        if (dir == Direction.UP || dir == Direction.DOWN) {
            dir = Direction.RIGHT;
        }
    }

    public void faceDown() {
        if (dir == Direction.RIGHT || dir == Direction.LEFT) {
            dir = Direction.DOWN;
        }
    }

    public void faceLeft() {
        if (dir == Direction.UP || dir == Direction.DOWN) {
            dir = Direction.LEFT;
        }
    }

    public void turnLeft() {
        turn(-1);
    }

    public void turnRight() {
        turn(1);
    }

    public void turn(int delta) {
        ArrayList<Direction> dirs = new ArrayList<Direction>();
        dirs.add(Direction.UP);
        dirs.add(Direction.RIGHT);
        dirs.add(Direction.DOWN);
        dirs.add(Direction.LEFT);
        this.dir = dirs.get((dirs.indexOf(this.dir) + delta) % dirs.size());
    }
}
