package homework;

/**
 * Subclass of the Figure class,
 * represents one single Pawn figure
 */
public class Pawn extends Figure {

    Pawn(int posX, int posY, Colour c) {
        super(posX, posY, c);
    }

    @Override
    public boolean validMoveCheck(int toX, int toY) {
        if (colour.equals(Colour.Black) && toX == x + 1 && toY == y && board.board[toX][toY] == null)
            return true;

        if (colour.equals(Colour.White) && toX == x - 1 && toY == y && board.board[toX][toY] == null)
            return true;

        if (colour.equals(Colour.Black) && (toX == x + 1 && toY == y + 1 && !board.isEmpty(toX, toY) || toX == x + 1 && toY == y - 1 && !board.isEmpty(toX, toY)))
            return true;

        if (colour.equals(Colour.White) && (toX == x - 1 && toY == y + 1 && !board.isEmpty(toX, toY) || toX == x - 1 && toY == y - 1 && !board.isEmpty(toX, toY)))
            return true;

        return false;

    }

    @Override
    public boolean moveTo(int toX, int toY) {
        if (!validMoveCheck(toX, toY)) {
            System.out.println(toX + " " + toY + " Invalid move");
            return false;
        } else {
            if (board.isEmpty(toX, toY)) {
                System.out.println(colour + " Pawn moved to " + toX + " " + toY);
                board.setField(x, y, null);
                x = toX;
                y = toY;
                graphicalX = y * 125;
                graphicalY = x * 125;
                board.setField(x, y, this);
                return true;

            } else if (board.getField(toX, toY).colour.equals(colour)) {
                System.out.println("You cant hit your own figures");
                return false;
            } else {
                System.out.println(colour + " Pawn moved to " + toX + " " + toY);
                board.getField(toX, toY).die();
                board.setField(x, y, null);
                x = toX;
                y = toY;
                graphicalX = y * 125;
                graphicalY = x * 125;
                board.setField(x, y, this);
                return true;
            }

        }

    }

    @Override
    public void die() {
        System.out.println(colour + " Pawn died");
        isAlive = false;
    }

}
