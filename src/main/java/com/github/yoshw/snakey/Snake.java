package com.github.yoshw.snakey;

import com.googlecode.lanterna.input.Key;

import java.util.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Snake {
    private World world;
    private ArrayList<BodySegment> body;
    private Head head;

    public Snake(int length, World world) {
        this.world = world;
        if (length > world.getWidth()/2) {
            throw new IllegalArgumentException("Snake too long!");
        }
        int row = world.getHeight()/2;
        int initCol = world.getWidth()/2;

        Cell currCell = world.cellAt(row, initCol);
        head = new Head(currCell);
        currCell.setOccupant(head);

        body = new ArrayList<BodySegment>();

        currCell = world.cellAt(row, initCol-1);
        extend(currCell);

        for (int i=2; i < length; i++) {
            currCell = world.cellAt(row, initCol-i);
            extend(currCell);
        }
    }

    public void update(Key inputKey) {
        this.updateDir(inputKey);
        world.requestMove(this);
    }

    public void updateDir(Key inputKey) {
        if (inputKey != null) {
            if (inputKey.getKind() == Key.Kind.ArrowUp) {
                head.faceUp();
            } else if (inputKey.getKind() == Key.Kind.ArrowRight) {
                head.faceRight();
            } else if (inputKey.getKind() == Key.Kind.ArrowDown) {
                head.faceDown();
            } else if (inputKey.getKind() == Key.Kind.ArrowLeft) {
                head.faceLeft();
            }
        }
    }

    public void move() {
        head.move();
        for (BodySegment seg : body) {
            seg.move();
        }

        for (BodySegment seg : body) {
            seg.updateDir();
        }
    }

    public void extend(Cell location) {
        Segment tail = tail();
        BodySegment newSeg = new BodySegment(location, tail);
        location.setOccupant(newSeg);
        body.add(newSeg);
    }

    public Head head() {
        return head;
    }

    public Segment tail() {
        if (body.isEmpty()) {
            return head;
        } else {
            return body.get(body.size() - 1);
        }
    }
}
