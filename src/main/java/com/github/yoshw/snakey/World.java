package com.github.yoshw.snakey;

import java.util.*;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by yosh on 18/11/15.
 */
public class World {
    private int height;
    private int width;
    private Grid grid;
    private Snake snake;
    private Random randomGenerator;

    public World(int height, int width, int snakeLength) {
        this.height = height;
        this.width = width;
        grid = new Grid(this);
        snake = new Snake(snakeLength, grid);
        randomGenerator = new Random();
    }

    public void render(Screen screen) {
        ArrayList<String> gridStr = grid.toStringArray();
        for (int i=0; i<grid.getHeight()+2; i++) {
            screen.putString(10, 5+i, gridStr.get(i),
                             Terminal.Color.BLACK, Terminal.Color.WHITE);
        }
    }

    public void update(Key inputKey) {
        snake.update(inputKey);
    }

    public void dropFruit() {
        ArrayList<Cell> freeCells = grid.getFreeCells();
        if (freeCells.isEmpty()) {
            return;
        }
        int index = randomGenerator.nextInt(freeCells.size());
        Cell cell = freeCells.get(index);
        // TODO make the call to setOccupant explicit, rather than in constructor
        new Fruit(cell);
    }

    public void updateFruitAndSnake() {
        dropFruit();
        snake.grow();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
