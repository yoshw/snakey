package com.github.yoshw.snakey;

import java.awt.*;
import java.util.*;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

import java.nio.charset.Charset;

/**
 * Snakey: a simple implementation of Snake.
 *
 */
public class Snakey {
    private static World world;
    private static Screen screen;
    private static boolean replay;

    public static void main( String[] args ) {
        screen = TerminalFacade.createScreen();
        replay = true;
        while (replay) {
            replay = start(screen);
        }
        System.exit(0);
    }

    public static boolean start(Screen screen) {
        init(screen);
        while (!world.gameIsOver()) {
            delay(100);
            update(screen);
        }
        return gameOver(screen);
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void init(Screen screen) {
        world = new World(20, 30, 5);
        screen.startScreen();
        world.spawnFruit();
    }

    public static void update(Screen screen) {
        world.update(screen.readInput());
        world.render(screen, Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.refresh();
    }

    public static boolean gameOver(Screen screen) {
        world.render(screen, Terminal.Color.BLACK, Terminal.Color.BLUE);
        screen.putString(10, 10, "Game Over!", Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.putString(10, 12, "(p)lay again? or (q)uit?", Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.refresh();

        Key inputKey;
        while (true) {
            inputKey = screen.readInput();
            if (inputKey != null) {
                if (inputKey.getKind() == Key.Kind.NormalKey) {
                    if (inputKey.getCharacter() == 'q') {
                        return false; // no replay
                    } else if (inputKey.getCharacter() == 'p') {
                        return true; //replay flag
                    }
                }
            }
        }
    }
}
