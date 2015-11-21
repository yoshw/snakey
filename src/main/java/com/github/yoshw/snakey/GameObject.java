package com.github.yoshw.snakey;
/**
 * Created by Yosh on 15/11/2015.
 */
public abstract class GameObject {
    protected Cell location;

    public GameObject(Cell loc) {
        if (loc.isOccupied()) {
            throw new IllegalArgumentException("cell already occupied!");
        }
        this.location = loc;
    }
}
