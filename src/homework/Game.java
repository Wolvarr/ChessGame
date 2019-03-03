package homework;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static homework.Colour.White;

/**
 * This class stores all data from a match
 * and responsible for saving and if possible
 * loading its state to/from a file
 */
public class Game implements Serializable {

    Board board;
    int moves;
    Colour currentPlayer;

    Game() {

        currentPlayer = White;
        board = new Board();
        moves = 0;
    }

    /**
     * Saves all details of the current game to a file
     *
     * @param fname The file, where the current games state is saved to
     */
    public void saveGame(String fname) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fname);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            System.out.println("Shit got saved yo");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Loads a saved game, sets it as the current game
     *
     * @param fname The file, that loads to be the current fame
     */
    public void loadGame(String fname) {
        try {
            FileInputStream fileIn = new FileInputStream(fname);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Game temp;
            temp = (Game) in.readObject();

            this.board = temp.board;
            this.moves = temp.moves;
            this.currentPlayer = temp.currentPlayer;
            in.close();
            System.out.println("Loaded bois");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
        }
    }

    /**
     * After a game is finished, updates the all time statistics
     *
     * @param textfile The text file, that stores the statistics
     */
    public void modifyStats(String textfile) throws IOException {
        // Number of matcher
        // Average moves
        //White wins
        //Balck wins
        //Draws

        int numOfMatches;
        int avgMoves;
        int blackWins;
        int whiteWins;
        int draws;

        Path filePath = Paths.get(textfile);
        Scanner scanner = new Scanner(filePath);


        numOfMatches = scanner.nextInt();
        avgMoves = scanner.nextInt();
        whiteWins = scanner.nextInt();
        blackWins = scanner.nextInt();
        draws = scanner.nextInt();

        PrintWriter writer = new PrintWriter(textfile);
        writer.println(numOfMatches + 1);
        writer.println((avgMoves * numOfMatches + moves) / (numOfMatches + 1));
        System.out.println("moves: " + moves + "avg moves: " + avgMoves);
        if (!board.blackKing.isAlive) writer.println(whiteWins + 1);
        else writer.println(whiteWins);
        if (!board.whiteKing.isAlive) writer.println(blackWins + 1);
        else writer.println(blackWins);
        if (board.whiteKing.isAlive && board.blackKing.isAlive) writer.println(draws + 1);
        else writer.println(draws);

        writer.close();


    }

    /**
     * Gets the statistics that stored in the given file
     *
     * @param textfile The text file, that stores the statistics
     * @return the array of the datas in the textfile
     */
    public int[] getStats(String textfile) throws IOException {

        Path filePath = Paths.get(textfile);
        Scanner scanner = new Scanner(filePath);

        int datas[] = new int[5];

        datas[0] = scanner.nextInt();
        datas[1] = scanner.nextInt();
        datas[2] = scanner.nextInt();
        datas[3] = scanner.nextInt();
        datas[4] = scanner.nextInt();

        return datas;
    }
}




