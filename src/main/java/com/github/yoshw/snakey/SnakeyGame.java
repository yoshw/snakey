package com.github.yoshw.snakey;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

import static com.github.yoshw.snakey.Utils.delay;

/**
 * Created by Yosh on 19/12/2015.
 */
public class SnakeyGame {
    private Screen screen;
    private WorldBuilder worldBuilder;
    private boolean continuePlaying = true;
    private boolean gameIsOver;

    public SnakeyGame(Screen screen, WorldBuilder worldBuilder) {
        this.screen = screen;
        this.worldBuilder = worldBuilder;
    }

    public void run() {
        screen.startScreen();
        while (continuePlaying) {
            startNewGame();
        }
        System.exit(0);
    }

    public void startNewGame() {
        gameIsOver = false;
        World world = worldBuilder.build();
        world.init();
        while(!gameIsOver) {
            delay(100);
            update(world);
            render(world);
        }
        gameOver(world);
    }

    public void update(World world) {
        world.update(screen.readInput());
        gameIsOver = world.gameIsOver();
    }

    public void render(World world) {
        render(world, Terminal.Color.BLACK, Terminal.Color.WHITE);
    }

    public void render(World world, Terminal.Color fgColor, Terminal.Color bgColor) {
        List<String> gridStrings = world.toStringArray();
        for (int i=0; i < world.getHeight()+2; i++) {
            screen.putString(3, 3+i, gridStrings.get(i), fgColor, bgColor);
        }

        screen.refresh();
    }

    public void gameOver(World world) {
        render(world, Terminal.Color.BLACK, Terminal.Color.BLUE);
        screen.putString(10, 10, "Game Over! Score: " + world.getScore(), Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.putString(10, 12, "(p)lay again? or (q)uit?", Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.refresh();

        Key inputKey;
        while (true) {
            inputKey = screen.readInput();
            if (inputKey != null && inputKey.getKind() == Key.Kind.NormalKey) {
                if (inputKey.getCharacter() == 'q') {
                    continuePlaying = false; // no replay
                    return;
                } else if (inputKey.getCharacter() == 'p') {
                    continuePlaying = true; //replay flag
                    return;
                }
            }
        }
    }

}
