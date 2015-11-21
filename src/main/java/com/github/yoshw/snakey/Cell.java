package com.github.yoshw.snakey;
/**
 * Created by Yosh on 15/11/2015.
 */
public class Cell {
    private World world;
    private int row, col;
    private GameObject occupant;

    public Cell(World world, int row, int col) {
        this.world = world;
        this.row = row;
        this.col = col;
    }

    public boolean isOccupied() {
        return this.occupant != null;
    }

    public void setOccupant(GameObject o) {
        if (o != null && this.isOccupied()) {
            throw new IllegalArgumentException("Cell already occupied!");
        }
        this.occupant = o;
    }

    public GameObject getOccupant() {
        return this.occupant;
    }

    public Cell neighbour(Direction dir) {
        int height = world.getHeight();
        int width = world.getWidth();
        if (dir == Direction.UP) {
            return world.cellAt((this.row - 1 + height) % height, this.col);
        } else if (dir == Direction.RIGHT) {
            return world.cellAt(this.row, (this.col + 1 + width) % width);
        } else if (dir == Direction.DOWN) {
            return world.cellAt((this.row + 1 + height) % height, this.col);
        } else {
            // dir == Direction.LEFT
            return world.cellAt(this.row, (this.col - 1 + width) % width);
        }
    }

    @Override
    public String toString() {
        if (this.isOccupied()) {
            return getOccupant().toString();
        } else {
            return " ";
        }
    }
}
