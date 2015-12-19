package com.github.yoshw.snakey;

import com.googlecode.lanterna.input.Key;

import java.util.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Snake {
    private Head head;
    private List<BodySegment> body;

    public Snake(Head head, List<BodySegment> body) {
        this.head = head;
        this.body = body;
    }

    public void update(Key inputKey) {
        this.updateDir(inputKey);
        head.requestMove();
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
