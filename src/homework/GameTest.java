package homework;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test critical methods of class Game
 */
class GameTest {

    Game game = new Game();


    @Test
    public void testSerializeGame() {
        //Checks both saveGame() and loadGame() methods
        //Making a move in the game, saving it, creating a new game, loading the saved state, and checking if the move was done in the second game as well

        game.board.board[1][0].moveTo(2, 0);
        game.saveGame("testSave");
        Game game2 = new Game();
        game2.loadGame("testSave");

        assertEquals(true, game2.board.isEmpty(1, 0));
        assertEquals(false, game2.board.isEmpty(2, 0));

    }


    @Test
    public void testGetStats() throws IOException {
        int testData[] = game.getStats("testText.txt");

        assertEquals(1, testData[0]);
        assertEquals(100, testData[4]);
    }
}