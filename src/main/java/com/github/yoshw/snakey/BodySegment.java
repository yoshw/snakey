package com.github.yoshw.snakey;

/**
 * Created by yosh on 20/11/15.
 */
public class BodySegment extends Segment {
    private Segment leader;
    private Cell leaderLoc;

    public BodySegment(Cell loc, Segment leader) {
        super(loc, leader.getDir());
        this.leader = leader;
        leaderLoc = leader.getLocation();
    }

    public void updateDir() {
        this.dir = this.leader.getDir();
    }

    public void move() {
        location.setOccupant(null);
        location = leaderLoc;
        location.setOccupant(this);
        leaderLoc = leader.getLocation();
    }
}
