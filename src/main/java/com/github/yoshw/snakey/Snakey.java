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

    public static void main( String[] args ) {
        screen = TerminalFacade.createScreen();
        start(screen);
    }

    public static void start(Screen screen) {
        init(screen);

        while (!world.gameIsOver()) {
            try {
                Thread.sleep(100);    //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            update(screen);
        }

        gameOver(screen);
    }

    public static void init(Screen screen) {
        world = new World(20, 30, 5);
        screen.startScreen();
        world.dropFruit();
    }

    public static void update(Screen screen) {
        world.update(screen.readInput());
        world.render(screen, Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.refresh();
    }

    public static void gameOver(Screen screen) {
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
                        System.exit(0);
                    } else if (inputKey.getCharacter() == 'p') {
                        start(screen);
                    }
                }
            }
        }
    }
}
