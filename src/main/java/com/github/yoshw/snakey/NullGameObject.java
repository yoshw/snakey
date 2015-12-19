package com.github.yoshw.snakey;

/**
 * Created by Yosh on 19/12/2015.
 */
public class NullGameObject extends GameObject {
    public NullGameObject() {
        // null object does not need a reference to its location
        super(null);
    }

    @Override
    public String toString() {
        return " ";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
