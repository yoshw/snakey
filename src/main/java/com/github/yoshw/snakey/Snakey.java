package com.github.yoshw.snakey;

import java.util.*;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

/**
 * Snakey: a simple implementation of Snake.
 *
 */
public class Snakey
{
    public static void main( String[] args )
    {
        World world = new World(40,40, 5);

        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        while (true) {
            try {
                Thread.sleep(200);    //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            world.update(screen.readInput());
            world.render(screen);
            screen.refresh();
        }
    }
}
