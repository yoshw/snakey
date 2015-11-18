package com.github.yoshw.snakey;

import java.util.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class Grid {
    private int height;
    private int width;
    private List<List<Cell>> grid;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;

        grid = new ArrayList<List<Cell>>();
        for (int i=0; i < this.height; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j=0; j < this.height; j++) {
                row.add(new Cell());
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
}
