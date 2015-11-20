package com.github.yoshw.snakey;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yosh on 15/11/2015.
 */
public class CellTest {
    private static Grid grid;
    private static Cell cell;

    @Before
    public void setUp() {
        World world = new World(10,10,1);
        grid = new Grid(world);
        cell = grid.cellAt(0,0);
    }

    @Test
    public void newCellIsNotOccupied() {
        assertFalse(cell.isOccupied());
    }

    @Test
    public void occupiedCellIsOccupied() {
        Segment seg = new Head(cell, Direction.RIGHT);
        assertTrue(cell.isOccupied());
    }

    @Test
    public void emptyCellIsNotOccupied() {
        Segment seg = new Head(cell, Direction.RIGHT);
        cell.setOccupant(null);
        assertFalse(cell.isOccupied());
    }

    @Test
    public void getOccupantReturnsOccupant() {
        GameObject obj = new Head(cell, Direction.RIGHT);
        assertSame(obj, cell.getOccupant());
    }

}