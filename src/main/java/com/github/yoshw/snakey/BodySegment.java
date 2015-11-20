package com.github.yoshw.snakey;

/**
 * Created by yosh on 20/11/15.
 */
public class BodySegment extends Segment {
    private Segment leader;
    private Cell leaderLoc;

    public BodySegment(Cell loc, Direction dir, Segment leader) {
        super(loc, dir);
        this.leader = leader;
        leaderLoc = leader.getLocation();
    }

    public void updateDir() {
        this.dir = this.leader.getDir();
    }

    public void move() {
        location.setOccupant(null);
        location = leaderLoc;
        leaderLoc = leader.getLocation();
        location.setOccupant(this);
    }
}
