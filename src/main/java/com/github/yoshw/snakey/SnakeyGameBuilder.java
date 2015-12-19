package com.github.yoshw.snakey;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;

/**
 * Created by Yosh on 19/12/2015.
 */
public class SnakeyGameBuilder {

    public SnakeyGameBuilder(String[] args) {
    }

    public SnakeyGame build() {
        Screen screen = TerminalFacade.createScreen();
        WorldBuilder builder = new WorldBuilder(20, 30, 5);
        return new SnakeyGame(screen, builder);
    }
}
