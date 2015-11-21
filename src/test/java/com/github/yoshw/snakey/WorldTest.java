package com.github.yoshw.snakey;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class WorldTest {
    private static World world;

    @Before
    public void setUp() throws Exception {
        world = new World(10,10,1);
    }

    @Test
    public void gridHeightIsInitialisedCorrectly() {
        assertEquals(world.getHeight(), 10);
    }

    @Test
    public void gridWidthIsInitialisedCorrectly() {
        assertEquals(world.getWidth(), 10);
    }

    /*
    @Test
    public void canSetGridHeight() {
        world.setHeight(6);
        assertEquals(world.getHeight(), 6);
    }

    @Test
    public void canSetGridWidth() {
        world.setWidth(6);
        assertEquals(world.getWidth(), 6);
    }
    */

    @Test
    public void cellAtReturnsACell() {
        assertTrue(world.cellAt(0,0) instanceof Cell);
    }

    @Test
    public void gridIsComposedOfCells() {
        for (int i=0; i < world.getHeight(); i++) {
            for (int j=0; j < world.getWidth(); j++) {
                assertTrue(world.cellAt(i,j) instanceof Cell);
            }
        }
    }

    /*
    @Test
    public void gridIsInitiallyEmpty() {
        for (int i=0; i < world.getHeight(); i++) {
            for (int j=0; j < world.getWidth(); j++) {
                assertFalse(world.cellAt(i,j).isOccupied());
            }
        }
    }
    */
}