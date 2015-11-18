package com.github.yoshw.snakey;

import java.util.*;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by yosh on 18/11/15.
 */
public class World {
    Grid grid;
    Snake snake;

    public World(int height, int width) {
        this.init(height, width);
    }

    public void init(int height, int width) {
        grid = new Grid(height, width);
        snake = new Snake(7, grid);
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
}
