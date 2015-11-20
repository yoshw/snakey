package com.github.yoshw.snakey;
/**
 * Created by Yosh on 15/11/2015.
 */
public class Cell {
    private Grid grid;
    private int row, col;
    private GameObject occupant;

    public Cell(Grid grid, int row, int col) {
        this.grid = grid;
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

    public Cell requestMove(Direction dir) {
        int rowdelta = 0;
        int coldelta = 0;
        if (dir == Direction.DOWN) {
            rowdelta = 1;
        } else if (dir == Direction.UP) {
            rowdelta = -1;
        } else if (dir == Direction.RIGHT) {
            coldelta = 1;
        } else if (dir == Direction.LEFT) {
            coldelta = -1;
        }
        int targetRow = (this.row + rowdelta) % grid.getHeight();
        if (targetRow < 0) {
            targetRow += grid.getHeight();
        }
        int targetCol = (this.col + coldelta) % grid.getWidth();
        if (targetCol < 0) {
            targetCol += grid.getWidth();
        }
        Cell target = grid.cellAt(targetRow, targetCol);
        if (target.isOccupied()) {
            if (target.getOccupant() instanceof Fruit) {
                target.setOccupant(null);
                grid.updateFruitAndSnake();
            } else {
                throw new IllegalArgumentException("CRASH! YOU LOSE.");
            }
        }
        return target;
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
