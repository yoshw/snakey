package com.github.yoshw;

import com.googlecode.lanterna.TerminalFacade;
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
        Terminal terminal = TerminalFacade.createTerminal(Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.moveCursor(10, 5);
        terminal.putCharacter('H');
        terminal.putCharacter('e');
        terminal.putCharacter('l');
        terminal.putCharacter('l');
        terminal.putCharacter('o');
        terminal.putCharacter(' ');
        terminal.putCharacter('W');
        terminal.putCharacter('o');
        terminal.putCharacter('r');
        terminal.putCharacter('l');
        terminal.putCharacter('d');
        terminal.putCharacter('!');
        terminal.moveCursor(10, 6);
        terminal.flush();
    }
}
