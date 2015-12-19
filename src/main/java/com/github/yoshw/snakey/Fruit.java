package com.github.yoshw.snakey;

/**
 * Created by yosh on 20/11/15.
 */
public class Fruit extends GameObject {
    public Fruit(Cell loc) {
        super(loc);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String toString() {
        return "o";
    }
}
