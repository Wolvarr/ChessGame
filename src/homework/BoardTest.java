package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test critical methods of class Board
 */
class BoardTest {

    Board b = new Board();
    King blackKing = new King(4, 4, Colour.Black);


    @Test
    public void testIsEmpty() {
        assertEquals(true, b.isEmpty(4, 4));
        assertEquals(false, b.isEmpty(0, 0));
    }

    @Test
    public void testInitBoard() {

        //Checking if the initialized board has empty spaces where it has to
        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                assertEquals(true, b.isEmpty(i, j));


        //Checking if the initialized board has figures  where it has to
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 8; j++)
                assertEquals(false, b.isEmpty(i, j));

        for (int i = 6; i < 8; i++)
            for (int j = 0; j < 8; j++)
                assertEquals(false, b.isEmpty(i, j));
    }


    @Test
    public void testGetField() {
        assertEquals(null, b.getField(4, 4));
        assertEquals(b.board[0][4], b.getField(0, 4));

    }

    @Test
    public void testSetField() {
        assertEquals(null, b.getField(4, 4));
        b.setField(4, 4, blackKing);
        assertEquals(blackKing, b.getField(4, 4));

    }
}