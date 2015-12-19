package com.github.yoshw.snakey;

import java.util.Map;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Cell {
    private World world;
    private Map<Direction, Cell> neighbours;
    private GameObject occupant;

    public Cell(World world, Map<Direction, Cell> neighbours, GameObject o) {
        this.world = world;
        this.neighbours = neighbours;
        this.occupant = o;
    }

    public boolean isOccupied() {
        return !this.occupant.isNull();
    }

    public void setOccupant(GameObject o) {
//        if (this.isOccupied()) {
//            throw new IllegalArgumentException("Cell already occupied! by " + occupant.toString());
//        }
        this.occupant = o;
    }

    public GameObject getOccupant() {
        return this.occupant;
    }

    public Cell getNeighbour(Direction dir) {
        return neighbours.get(dir);
    }

    @Override
    public String toString() {
        return getOccupant().toString();
    }

    public Map<Direction,Cell> getNeighbours() {
        return neighbours;
    }

    public void requestMove() {
        world.handleRequestToMoveTo(this);
    }
}
