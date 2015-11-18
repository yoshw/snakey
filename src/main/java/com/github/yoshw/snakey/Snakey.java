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
        Grid grid = new Grid(10,10);
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        ArrayList<String> gridStr = grid.toStringArray();
        for (int i=0; i<grid.getHeight()+2; i++) {
            screen.putString(10, 5+i, gridStr.get(i), Terminal.Color.BLACK, Terminal.Color.WHITE);
        }
        screen.refresh();
    }
}
