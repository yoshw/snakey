package com.github.yoshw.snakey;

import com.googlecode.lanterna.input.Key;

import java.util.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Snake {
    private Grid grid;
    private ArrayList<BodySegment> body;
    private Head head;

    public Snake(int length, Grid grid) {
        this.grid = grid;
        if (length > grid.getWidth()/2) {
            throw new IllegalArgumentException("Snake too long!");
        }
        int startingRow = grid.getHeight()/2;
        int currCol = grid.getWidth()/2;
        head = new Head(grid.cellAt(startingRow, currCol));
        body = new ArrayList<BodySegment>();
        body.add(new BodySegment(grid.cellAt(startingRow, currCol-1), Direction.RIGHT, head));
        for (int i=2; i < length; i++) {
            body.add(new BodySegment(grid.cellAt(startingRow, currCol-i), Direction.RIGHT,
                     body.get(i-2)));
        }
    }

    public void update(Key inputKey) {
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

        head.move();
        for (BodySegment seg : body) {
            seg.move();
        }

        for (BodySegment seg : body) {
            seg.updateDir();
        }
    }

    public int length() {
        return 1 + body.size();
    }

    public void grow() {
        BodySegment tail = body.get(body.size()-1);
        body.add(new BodySegment(grid.cellAt(0,0), Direction.RIGHT, tail));
    }
}
