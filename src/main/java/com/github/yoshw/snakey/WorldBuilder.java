package com.github.yoshw.snakey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Yosh on 19/12/2015.
 */
public class WorldBuilder {
    private int height;
    private int width;
    private int snakeLength;

    public WorldBuilder(int height, int width, int snakeLength) {
        this.height = height;
        this.width = width;
        this.snakeLength = snakeLength;
    }

    public World build() {
        Random randomGenerator = new Random();
        List<List<Cell>> grid = new ArrayList<List<Cell>>();
        World world = new World(height, width, grid, randomGenerator);

        createCells(grid, world);
        connectNeighbouringCells(world);

        Cell headCell = world.cellAt(height/2, width/2);
        Snake snake = buildSnake(headCell);
        world.setSnake(snake);

        return world;
    }

    public void createCells(List<List<Cell>> grid, World world) {
        for (int i = 0; i < height; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < width; j++) {
                row.add(new Cell(world, new HashMap<Direction, Cell>(), new NullGameObject()));
            }
            grid.add(row);
        }
    }

    public void connectNeighbouringCells(World world) {
        Cell curr;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                curr = world.cellAt(i, j);
                curr.getNeighbours().put(Direction.RIGHT, world.cellAt(i, (j + 1 + width) % width));
                curr.getNeighbours().put(Direction.DOWN, world.cellAt((i + 1 + height) % height, j));
                curr.getNeighbours().put(Direction.LEFT, world.cellAt(i, (j - 1 + width) % width));
                curr.getNeighbours().put(Direction.UP, world.cellAt((i - 1 + height) % height, j));
            }
        }
    }

    public Snake buildSnake(Cell headCell) {
        if (snakeLength > width/2) {
            throw new IllegalArgumentException("Snake too long!");
        }

        Head head = new Head(headCell);
        headCell.setOccupant(head);
        List<BodySegment> body = new ArrayList<BodySegment>();

        Snake snake = new Snake(head, body);

        Cell currCell = headCell.getNeighbour(Direction.LEFT);
        snake.extend(currCell);
        for (int i=2; i < snakeLength; i++) {
            currCell = currCell.getNeighbour(Direction.LEFT);
            snake.extend(currCell);
        }

        return snake;
    }
}
