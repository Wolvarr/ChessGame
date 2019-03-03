package homework;

import java.io.Serializable;

import static homework.Colour.Black;
import static homework.Colour.White;

/**
 * The class that represents the board
 * that the figures stands on, an can move on
 */
public class Board implements Serializable {
    Figure board[][] = new Figure[8][8];
    Pawn blackPawn1;
    Pawn blackPawn2;
    Pawn blackPawn3;
    Pawn blackPawn4;
    Pawn blackPawn5;
    Pawn blackPawn6;
    Pawn blackPawn7;
    Pawn blackPawn8;

    Pawn whitePawn1;
    Pawn whitePawn2;
    Pawn whitePawn3;
    Pawn whitePawn4;
    Pawn whitePawn5;
    Pawn whitePawn6;
    Pawn whitePawn7;
    Pawn whitePawn8;

    Rook blackRook1;
    Horse blackHorse1;
    Bishop blackBishop1;
    King blackKing;
    Queen blackQueen;
    Bishop blackBishop2;
    Horse blackHorse2;
    Rook blackRook2;

    Rook whiteRook1;
    Horse whiteHorse1;
    Bishop whiteBishop1;
    King whiteKing;
    Queen whiteQueen;
    Bishop whiteBishop2;
    Horse whiteHorse2;
    Rook whiteRook2;

    Board() {


        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                setField(i, j, null);

        blackPawn1 = new Pawn(1, 0, Black);
        blackPawn2 = new Pawn(1, 1, Black);
        blackPawn3 = new Pawn(1, 2, Black);
        blackPawn4 = new Pawn(1, 3, Black);
        blackPawn5 = new Pawn(1, 4, Black);
        blackPawn6 = new Pawn(1, 5, Black);
        blackPawn7 = new Pawn(1, 6, Black);
        blackPawn8 = new Pawn(1, 7, Black);


        blackRook1 = new Rook(0, 0, Black);
        blackHorse1 = new Horse(0, 1, Black);
        blackBishop1 = new Bishop(0, 2, Black);
        blackKing = new King(0, 3, Black);
        blackQueen = new Queen(0, 4, Black);
        blackBishop2 = new Bishop(0, 5, Black);
        blackHorse2 = new Horse(0, 6, Black);
        blackRook2 = new Rook(0, 7, Black);


        board[1][0] = blackPawn1;
        board[1][1] = blackPawn2;
        board[1][2] = blackPawn3;
        board[1][3] = blackPawn4;
        board[1][4] = blackPawn5;
        board[1][5] = blackPawn6;
        board[1][6] = blackPawn7;
        board[1][7] = blackPawn8;

        board[0][0] = blackRook1;
        board[0][1] = blackHorse1;
        board[0][2] = blackBishop1;
        board[0][3] = blackKing;
        board[0][4] = blackQueen;
        board[0][5] = blackBishop2;
        board[0][6] = blackHorse2;
        board[0][7] = blackRook2;

        for (int i = 0; i < 8; i++)
            board[0][i].board = this;


        for (int i = 0; i < 8; i++)
            board[1][i].board = this;

        whitePawn1 = new Pawn(6, 0, White);
        whitePawn2 = new Pawn(6, 1, White);
        whitePawn3 = new Pawn(6, 2, White);
        whitePawn4 = new Pawn(6, 3, White);
        whitePawn5 = new Pawn(6, 4, White);
        whitePawn6 = new Pawn(6, 5, White);
        whitePawn7 = new Pawn(6, 6, White);
        whitePawn8 = new Pawn(6, 7, White);

        board[6][0] = whitePawn1;
        board[6][1] = whitePawn2;
        board[6][2] = whitePawn3;
        board[6][3] = whitePawn4;
        board[6][4] = whitePawn5;
        board[6][5] = whitePawn6;
        board[6][6] = whitePawn7;
        board[6][7] = whitePawn8;

        whiteRook1 = new Rook(7, 0, White);
        whiteHorse1 = new Horse(7, 1, White);
        whiteBishop1 = new Bishop(7, 2, White);
        whiteQueen = new Queen(7, 4, White);
        whiteKing = new King(7, 3, White);
        whiteBishop2 = new Bishop(7, 5, White);
        whiteHorse2 = new Horse(7, 6, White);
        whiteRook2 = new Rook(7, 7, White);

        board[7][0] = whiteRook1;
        board[7][1] = whiteHorse1;
        board[7][2] = whiteBishop1;
        board[7][4] = whiteQueen;
        board[7][3] = whiteKing;
        board[7][5] = whiteBishop2;
        board[7][6] = whiteHorse2;
        board[7][7] = whiteRook2;

        for (int i = 0; i < 8; i++)
            board[7][i].board = this;


        for (int i = 0; i < 8; i++)
            board[6][i].board = this;

        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                setField(i, j, null);

    }

    /**
     * Checks if the given coordinates of a
     * position of the board
     * have a figure on it, or not
     *
     * @param x x coordinate of the target field
     * @param y y coordinate of the target field
     * @return a boolean, that is true if there is no figure on the given position
     */
    public boolean isEmpty(int x, int y) {
        return board[x][y] == null;
    }


    /**
     * Gets the Figure that stands on the given position,
     * of if that is empty, gets a nullpointer
     *
     * @param x x coordinate of the target field
     * @param y y coordinate of the target field
     * @return The figure that stands on the given position
     */
    public Figure getField(int x, int y) {
        if (isEmpty(x, y))
            return null;
        else
            return board[x][y];
    }

    /**
     * Places the given figure to the given position
     * of the board, is the position is empty
     *
     * @param x      x coordinate of the target field
     * @param y      y coordinate of the target field
     * @param figure the figure, that is going to be placed to the position
     */
    public void setField(int x, int y, Figure figure) {
        board[x][y] = figure;
    }

}
