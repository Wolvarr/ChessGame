package homework;

import org.junit.jupiter.api.Test;

import static homework.Colour.Black;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test critical methods of class Queen
 */
class QueenTest {
    Board b = new Board();
    Queen testQueen = new Queen(4, 4, Black);


    @Test
    public void testValidMoveCheck() {
        b.board[4][4] = testQueen;
        assertEquals(true, testQueen.validMoveCheck(5, 4));

        assertEquals(true, testQueen.validMoveCheck(5, 5));

        assertEquals(true, testQueen.validMoveCheck(4, 5));

        assertEquals(true, testQueen.validMoveCheck(3, 3));

        assertEquals(false, testQueen.validMoveCheck(8, 8));

        assertEquals(false, testQueen.validMoveCheck(3, 7));
    }

    @Test
    public void testMoveTo() {
        testQueen.board = b;

        assertEquals(4, testQueen.x);
        assertEquals(4, testQueen.y);

        testQueen.moveTo(5, 5);

        assertEquals(5, testQueen.x);
        assertEquals(5, testQueen.x);
    }

    @Test
    public void testDie() {
        assertEquals(true, testQueen.isAlive);

        testQueen.die();

        assertEquals(false, testQueen.isAlive);
    }
}