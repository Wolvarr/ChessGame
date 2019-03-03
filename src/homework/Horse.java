package homework;

/**
 * Subclass of the Figure class,
 * represents one single Horse figure
 */
public class Horse extends Figure {

    Horse(int posX, int posY, Colour c) {
        super(posX, posY, c);
    }

    @Override
    public boolean validMoveCheck(int toX, int toY) {
        if (toX > 7 || toY > 7 || toX < 0 || toY < 0)
            return false;

        if ((toX == x - 2 && toY == y - 1) || (toX == x - 1 && toY == y - 2) || (toX == x + 1 && toY == y - 2) || (toX == x + 2 && toY == y - 1) || (toX == x - 2 && toY == y + 1) || (toX == x - 1 && toY == y + 2) || (toX == x + 2 && toY == y + 1) || (toX == x + 1 && toY == y + 2))
            return true;

        return false;
    }

    @Override
    public boolean moveTo(int toX, int toY) {
        if (!validMoveCheck(toX, toY))
            System.out.println(toX + " " + toY + " Invalid move");
        else {
            if (board.isEmpty(toX, toY)) {
                System.out.println(colour + " Horse moved to " + toX + " " + toY);
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
                System.out.println(colour + " Horse moved to " + toX + " " + toY);
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
        return false;
    }

    @Override
    public void die() {
        System.out.println(colour + " Horse died");
        isAlive = false;
    }

}

