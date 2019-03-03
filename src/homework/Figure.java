package homework;

import java.io.Serializable;

/**
 * The abstract superclass for all types of figures
 */
public abstract class Figure implements Serializable {
    int x;
    int y;
    int graphicalX;
    int graphicalY;
    Colour colour;
    Board board;
    boolean isAlive;

    Figure(int posX, int posY, Colour c) {
        isAlive = true;
        x = posX;
        y = posY;
        graphicalX = y * 125;
        graphicalY = x * 125;
        colour = c;
    }

    /**
     * Checks if the figures move is possible to the
     * given position
     *
     * @param toX
     * @param toY
     * @return asdasdasd
     */
    public abstract boolean validMoveCheck(int toX, int toY);

    /**
     * Checks if the figures strait move to the target field
     * is either possible, and do not touches any
     * nonempty fields during the move
     *
     * @param toX
     * @param toY
     * @return
     */
    public boolean straightMoveCheck(int toX, int toY) {
        if (x < toX)
            for (int i = x + 1; i < toX; i++)
                if (board.getField(i, y) != null)
                    return false;

        if (x > toX)
            for (int i = x - 1; i > toX; i--)
                if (board.getField(i, y) != null)
                    return false;

        if (y < toY)
            for (int i = y + 1; i < toY; i++)
                if (board.getField(x, i) != null)
                    return false;

        if (y > toY)
            for (int i = y - 1; i > toY; i--)
                if (board.getField(x, i) != null)
                    return false;

        return true;
    }

    /**
     * Checks if the figures diagonal move to the target field
     * is either possible, and do not touches any
     * nonempty fields during the move
     *
     * @param toX x coordinate of the target field
     * @param toY y coordinate of the target field
     * @return the validness of the move
     */
    public boolean validDiagonalMove(int toX, int toY) {
        if (x < toX && y < toY) {
            int tmpX = x + 1;
            int tmpY = y + 1;
            while (tmpX != toX) {
                if (board.getField(tmpX, tmpY) != null)
                    return false;
                tmpX++;
                tmpY++;
            }
        }
        if (x > toX && y > toY) {
            int tmpX = x - 1;
            int tmpY = y - 1;
            while (tmpX != toX) {
                if (board.getField(tmpX, tmpY) != null)
                    return false;
                tmpX--;
                tmpY--;
            }
        }

        if (x < toX && y > toY) {
            int tmpX = x + 1;
            int tmpY = y - 1;
            while (tmpX != toX) {
                if (board.getField(tmpX, tmpY) != null)
                    return false;
                tmpX++;
                tmpY--;
            }
        }
        if (x > toX && y < toY) {
            int tmpX = x - 1;
            int tmpY = y + 1;
            while (tmpX != toX) {
                if (board.getField(tmpX, tmpY) != null)
                    return false;
                tmpX--;
                tmpY++;
            }
        }

        return true;
    }


    /**
     * Moves the figure to the coordinates added as parameters,
     * if the move is possible and true
     *
     * @param toX x coordinate of the target field
     * @param toY y coordinate of the target field
     * @return the validness of the move
     */
    public abstract boolean moveTo(int toX, int toY);


    /**
     * This method is responsible for setting a
     * figures state after it has been hit by other figure
     */
    public abstract void die();


}
