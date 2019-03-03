package homework;

/**
 * Subclass of the Figure class,
 * represents one single King figure
 */
public class King extends Figure {

    King(int posX, int posY, Colour c) {
        super(posX, posY, c);
    }


    @Override
    public boolean validMoveCheck(int toX, int toY) {
        if (toX > x + 1 || toX < x - 1 || toY > y + 1 || toY < y - 1 || toY > 7 || toY < 0 || toX > 7 || toX < 0)
            return false;

        return true;
    }

    @Override
    public boolean moveTo(int toX, int toY) {

        if (!validMoveCheck(toX, toY)) {
            System.out.println("Invalid move");
            return false;
        }
        if (board.isEmpty(toX, toY)) {
            System.out.println(colour + " King moved to " + toX + " " + toY);
            board.setField(x, y, null);
            x = toX;
            y = toY;
            graphicalX = y * 125;
            graphicalY = x * 125;
            board.setField(x, y, this);
            return true;

        } else {
            if (board.getField(toX, toY).colour.equals(colour)) {
                System.out.println("You cant hit your own figures");
                return false;
            } else {
                System.out.println(colour + " King moved to " + toX + " " + toY);
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
        System.out.println(colour + " King died");
        isAlive = false;
    }


}
