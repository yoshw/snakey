package com.github.yoshw.snakey;

/**
 * Created by Yosh on 19/12/2015.
 */
public class Utils {
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
