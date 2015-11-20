package com.github.yoshw.snakey;

import java.util.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Grid {
    private World world;
    private int height;
    private int width;
    private List<List<Cell>> grid;

    public Grid(World world) {
        this.world = world;
        this.height = world.getHeight();
        this.width = world.getWidth();

        grid = new ArrayList<List<Cell>>();
        for (int i=0; i < this.height; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j=0; j < this.width; j++) {
                row.add(new Cell(this, i, j));
            }
            grid.add(row);
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Cell cellAt(int row, int col) {
        return this.grid.get(row).get(col);
    }

    public ArrayList<String> toStringArray() {
        ArrayList<String> out = new ArrayList<String>();

        StringBuilder top = new StringBuilder(this.width+2);
        top.append(' ');
        for (int j=0; j < this.width; j++) {
            top.append('_');
        }
        top.append(' ');
        out.add(top.toString());

        for (int i=0; i < this.height; i++) {
            StringBuilder row = new StringBuilder(this.width+2);
            row.append('|');
            for (int j=0; j < this.width; j++) {
                String cellStr = grid.get(i).get(j).toString();
                row.append(cellStr);
            }
            row.append('|');
            out.add(row.toString());
        }

        StringBuilder bottom = new StringBuilder(this.width+2);
        bottom.append(' ');
        for (int j=0; j < this.width; j++) {
            bottom.append('-');
        }
        bottom.append(' ');
        out.add(bottom.toString());

        return out;
    }

    @Override
    public String toString() {
        ArrayList<String> arr = this.toStringArray();
        return String.join("\n", arr);
    }

    public ArrayList<Cell> getFreeCells() {
        ArrayList<Cell> freeCells = new ArrayList<Cell>();
        for (int i=0; i<this.height; i++) {
            for (int j=0; j<this.width; j++) {
                Cell cell = this.cellAt(i, j);
                if (!cell.isOccupied()) {
                    freeCells.add(cell);
                }
            }
        }
        return freeCells;
    }

    public void updateFruitAndSnake() {
        world.updateFruitAndSnake();
    }
}
