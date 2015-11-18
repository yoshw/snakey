package com.github.yoshw.snakey;

import com.googlecode.lanterna.input.Key;

import java.util.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Snake {
    ArrayList<Segment> body;
    Segment head;

    public Snake(int length, Grid grid) {
        if (length > grid.getWidth()/2) {
            throw new IllegalArgumentException("Snake too long!");
        }
        body = new ArrayList<Segment>();
        int startingRow = grid.getHeight()/2;
        int currCol = grid.getWidth()/2;
        body.add(new Segment(grid.cellAt(startingRow, currCol)));
        for (int i=1; i < length; i++) {
            body.add(new Segment(grid.cellAt(startingRow, currCol-i), Direction.RIGHT, body.get(i-1)));
        }
        head = body.get(0);
        assert(head != null);
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

        for (Segment seg : body) {
            seg.move();
        }

        for (Segment seg : body) {
            seg.updateDir();
        }
    }
}
