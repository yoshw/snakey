package com.github.yoshw.snakey;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.Key;

/**
 * Snakey: a simple implementation of Snake.
 *
 */
public class Snakey {
    public static void main( String[] args ) {
        SnakeyGame game = new SnakeyGameBuilder(args).build();
        game.run();
    }
}
