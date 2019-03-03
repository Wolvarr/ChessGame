package homework;

/**
 * Subclass of the Figure class,
 * represents one single Rook figure
 */
public class Rook extends Figure {

    Rook(int posX, int posY, Colour c) {
        super(posX, posY, c);
    }

    public @Override
    boolean validMoveCheck(int toX, int toY) {

        if (toX > 7 || toY > 7 || toX < 0 || toY < 0)
            return false;

        if (x != toX && y != toY)
            return false;

        if (x == toX || y == toY) {
            if (!straightMoveCheck(toX, toY))
                return false;
        }

        return true;
    }

    @Override
    public boolean moveTo(int toX, int toY) {
        if (!validMoveCheck(toX, toY)) {
            System.out.println(toX + " " + toY + " Invalid move");
            return false;
        } else {
            if (board.isEmpty(toX, toY)) {
                System.out.println(colour + " Rock moved to " + toX + " " + toY);
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
                System.out.println(colour + " Rock moved to " + toX + " " + toY);
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
        System.out.println(colour + " Bishop died");
        isAlive = false;
    }

}
