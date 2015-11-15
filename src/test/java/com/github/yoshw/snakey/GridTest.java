package com.github.yoshw.snakey;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yosh on 15/11/2015.
 */
public class GridTest {
    private static Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(3, 3);
    }

    @Test
    public void gridHeightIsInitialisedCorrectly() {
        assertEquals(grid.getHeight(), 3);
    }

    @Test
    public void gridWidthIsInitialisedCorrectly() {
        assertEquals(grid.getWidth(), 3);
    }

    @Test
    public void canSetGridHeight() {
        grid.setHeight(6);
        assertEquals(grid.getHeight(), 6);
    }

    @Test
    public void canSetGridWidth() {
        grid.setWidth(6);
        assertEquals(grid.getWidth(), 6);
    }

    @Test
    public void cellAtReturnsACell() {
        assertTrue(grid.cellAt(0,0) instanceof Cell);
    }

    @Test
    public void gridIsComposedOfCells() {
        for (int i=0; i < grid.getHeight(); i++) {
            for (int j=0; j < grid.getWidth(); j++) {
                assertTrue(grid.cellAt(i,j) instanceof Cell);
            }
        }
    }

    @Test
    public void gridIsInitiallyEmpty() {
        for (int i=0; i < grid.getHeight(); i++) {
            for (int j=0; j < grid.getWidth(); j++) {
                assertFalse(grid.cellAt(i,j).isOccupied());
            }
        }
    }
}