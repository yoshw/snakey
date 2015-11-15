package com.github.yoshw.snakey;
/**
 * Created by Yosh on 15/11/2015.
 */
public class Cell {
    private GameObject occupant;

    public Cell() { }

    public boolean isOccupied() {
        return this.occupant != null;
    }

    public void setOccupant(GameObject o) {
        this.occupant = o;
    }

    public GameObject getOccupant() {
        return this.occupant;
    }
}
