package com.github.yoshw.snakey;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yosh on 15/11/2015.
 */
public class CellTest {
    private static Cell cell;

    @Before
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void emptyCellIsNotOccupied() {
        assertFalse(cell.isOccupied());
    }

    @Test
    public void occupiedCellIsOccupied() {
        cell.setOccupant(new GameObject());
        assertTrue(cell.isOccupied());
    }
}