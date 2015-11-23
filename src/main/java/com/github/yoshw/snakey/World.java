package com.github.yoshw.snakey;

import java.util.*;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * Created by yosh on 18/11/15.
 */
public class World {
    private int height;
    private int width;
    private List<List<Cell>> grid;
    private Snake snake;
    private Random randomGenerator;
    private boolean gameOver;

    public World(int height, int width, int snakeLength) {
        this.height = height;
        this.width = width;
        randomGenerator = new Random();

        grid = new ArrayList<List<Cell>>();
        for (int i=0; i < this.height; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j=0; j < this.width; j++) {
                row.add(new Cell(this, i, j));
            }
            grid.add(row);
        }

        snake = new Snake(snakeLength, this);
    }

    public void render(Screen screen, Color fgColor, Color bgColor) {
        ArrayList<String> gridStr = toStringArray();
        for (int i=0; i < height+2; i++) {
            screen.putString(3, 3+i, gridStr.get(i), fgColor, bgColor);
        }
    }

    public void update(Key inputKey) {
        snake.update(inputKey);
    }

    public void spawnFruit() {
        ArrayList<Cell> freeCells = getFreeCells();
        if (freeCells.isEmpty()) {
            return;
        }
        int index = randomGenerator.nextInt(freeCells.size());
        Cell cell = freeCells.get(index);
        Fruit fruit = new Fruit(cell);
        cell.setOccupant(fruit);
    }

    public void requestMove(Snake snake) {
        Cell headLoc = snake.head().getLocation();
        Cell target = headLoc.neighbour(snake.head().getDir());
        if (target.isOccupied()) {
            if (target.getOccupant() instanceof Fruit) {
                target.setOccupant(null);
                Cell tailLoc = snake.tail().getLocation();
                snake.move();
                snake.extend(tailLoc);
                spawnFruit();
            } else {
                gameOver = true;
                return;
            }
        }
        snake.move();
    }

    public boolean gameIsOver() {
        return gameOver;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell cellAt(int row, int col) {
        return grid.get(row).get(col);
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
}
