package com.github.yoshw.snakey;
/**
 * Created by Yosh on 15/11/2015.
 */
public abstract class GameObject {
    protected Cell location;

    public GameObject(Cell loc) {
        this.location = loc;
    }

    abstract public boolean isNull();
}
