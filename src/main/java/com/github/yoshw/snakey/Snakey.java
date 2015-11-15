package com.github.yoshw.snakey;

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
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        screen.putString(10, 5, "Hello, worldo!", Terminal.Color.BLACK, Terminal.Color.WHITE);
        screen.refresh();
    }
}
