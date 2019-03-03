package homework;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static homework.Colour.Black;
import static homework.Colour.White;

/**
 * This class s responsible for the main mechanism
 * of a single game of chess.
 * Draws the board, the figures, moves them
 * and handles mouse clicks from both players
 */
public class Game_mechanism extends Application {

    static Scene gameScene;
    Game g = new Game();
    Button saveBt = new Button("Save Game and Exit");
    Button drawBt = new Button("End in Draw");

    /**
     * This method starts only the the game itself, without the menu and other features
     * When the Start Game from the menu is hit,
     * this method starts the game
     *
     * @param theStage The stage to display graphics on
     */
    @Override
    public void start(Stage theStage) {


        theStage.setTitle("Chess game");

        saveBt.setMinSize(200, 100);
        saveBt.setTranslateX(1100);
        saveBt.setTranslateY(100);
        saveBt.setStyle("-fx-font: 24 arial;");

        drawBt.setMinSize(200, 100);
        drawBt.setTranslateX(1100);
        drawBt.setTranslateY(750);
        drawBt.setStyle("-fx-font: 24 arial;");


        Group root = new Group();
        gameScene = new Scene(root, 1500, 1000);
        theStage.setScene(gameScene);

        Canvas canvas = new Canvas(1500, 1000);
        root.getChildren().addAll(canvas, saveBt, drawBt);

        GraphicsContext gc = canvas.getGraphicsContext2D();


        Image board = new Image("board.png");

        Image whiteking = new Image("whiteking.png");
        Image whitequeen = new Image("whitequeen.png");
        Image whitebishop1 = new Image("whitebishop.png");
        Image whitebishop2 = new Image("whitebishop.png");
        Image whitehorse1 = new Image("whitehorse.png");
        Image whitehorse2 = new Image("whitehorse.png");
        Image whiterook1 = new Image("whiterook.png");
        Image whiterook2 = new Image("whiterook.png");
        Image whitepawn1 = new Image("whitepawn.png");
        Image whitepawn2 = new Image("whitepawn.png");
        Image whitepawn3 = new Image("whitepawn.png");
        Image whitepawn4 = new Image("whitepawn.png");
        Image whitepawn5 = new Image("whitepawn.png");
        Image whitepawn6 = new Image("whitepawn.png");
        Image whitepawn7 = new Image("whitepawn.png");
        Image whitepawn8 = new Image("whitepawn.png");

        Image blackking = new Image("blackking.png");
        Image blackqueen = new Image("blackqueen.png");
        Image blackbishop1 = new Image("blackbishop.png");
        Image blackbishop2 = new Image("blackbishop.png");
        Image blackhorse1 = new Image("blackhorse.png");
        Image blackhorse2 = new Image("blackhorse.png");
        Image blackrook1 = new Image("blackrook.png");
        Image blackrook2 = new Image("blackrook.png");
        Image blackpawn1 = new Image("blackpawn.png");
        Image blackpawn2 = new Image("blackpawn.png");
        Image blackpawn3 = new Image("blackpawn.png");
        Image blackpawn4 = new Image("blackpawn.png");
        Image blackpawn5 = new Image("blackpawn.png");
        Image blackpawn6 = new Image("blackpawn.png");
        Image blackpawn7 = new Image("blackpawn.png");
        Image blackpawn8 = new Image("blackpawn.png");

        Image blackmovessign = new Image("blackmoves.png");
        Image whitemovessign = new Image("whitemoves.png");


        gc.drawImage(board, 0, 0);

        if (g.board.whiteRook1.isAlive)
            gc.drawImage(whiterook1, g.board.whiteRook1.graphicalX, g.board.whiteRook1.graphicalY);
        if (g.board.whiteHorse1.isAlive)
            gc.drawImage(whitehorse1, g.board.whiteHorse1.graphicalX, g.board.whiteHorse1.graphicalY);
        if (g.board.whiteBishop1.isAlive)
            gc.drawImage(whitebishop1, g.board.whiteBishop1.graphicalX, g.board.whiteBishop1.graphicalY);
        if (g.board.whiteKing.isAlive)
            gc.drawImage(whiteking, g.board.whiteKing.graphicalX, g.board.whiteKing.graphicalY);
        if (g.board.whiteQueen.isAlive)
            gc.drawImage(whitequeen, g.board.whiteQueen.graphicalX, g.board.whiteQueen.graphicalY);
        if (g.board.whiteBishop2.isAlive)
            gc.drawImage(whitebishop2, g.board.whiteBishop2.graphicalX, g.board.whiteBishop2.graphicalY);
        if (g.board.whiteHorse2.isAlive)
            gc.drawImage(whitehorse2, g.board.whiteHorse2.graphicalX, g.board.whiteHorse2.graphicalY);
        if (g.board.whiteRook2.isAlive)
            gc.drawImage(whiterook2, g.board.whiteRook2.graphicalX, g.board.whiteRook2.graphicalY);
        if (g.board.whitePawn1.isAlive)
            gc.drawImage(whitepawn1, g.board.whitePawn1.graphicalX, g.board.whitePawn1.graphicalY);
        if (g.board.whitePawn2.isAlive)
            gc.drawImage(whitepawn2, g.board.whitePawn2.graphicalX, g.board.whitePawn2.graphicalY);
        if (g.board.whitePawn3.isAlive)
            gc.drawImage(whitepawn3, g.board.whitePawn3.graphicalX, g.board.whitePawn3.graphicalY);
        if (g.board.whitePawn4.isAlive)
            gc.drawImage(whitepawn4, g.board.whitePawn4.graphicalX, g.board.whitePawn4.graphicalY);
        if (g.board.whitePawn5.isAlive)
            gc.drawImage(whitepawn5, g.board.whitePawn5.graphicalX, g.board.whitePawn5.graphicalY);
        if (g.board.whitePawn6.isAlive)
            gc.drawImage(whitepawn6, g.board.whitePawn6.graphicalX, g.board.whitePawn6.graphicalY);
        if (g.board.whitePawn7.isAlive)
            gc.drawImage(whitepawn7, g.board.whitePawn7.graphicalX, g.board.whitePawn7.graphicalY);
        if (g.board.whitePawn8.isAlive)
            gc.drawImage(whitepawn8, g.board.whitePawn8.graphicalX, g.board.whitePawn8.graphicalY);


        if (g.board.blackRook1.isAlive)
            gc.drawImage(blackrook1, g.board.blackRook1.graphicalX, g.board.blackRook1.graphicalY);
        if (g.board.blackHorse1.isAlive)
            gc.drawImage(blackhorse1, g.board.blackHorse1.graphicalX, g.board.blackRook1.graphicalY);
        if (g.board.blackBishop1.isAlive)
            gc.drawImage(blackbishop1, g.board.blackBishop1.graphicalX, g.board.blackBishop1.graphicalY);
        if (g.board.blackKing.isAlive)
            gc.drawImage(blackking, g.board.blackKing.graphicalX, g.board.blackKing.graphicalY);
        if (g.board.blackQueen.isAlive)
            gc.drawImage(blackqueen, g.board.blackQueen.graphicalX, g.board.blackQueen.graphicalY);
        if (g.board.blackBishop2.isAlive)
            gc.drawImage(blackbishop2, g.board.blackBishop2.graphicalX, g.board.blackBishop2.graphicalY);
        if (g.board.blackHorse2.isAlive)
            gc.drawImage(blackhorse2, g.board.blackHorse2.graphicalX, g.board.blackHorse2.graphicalY);
        if (g.board.blackRook2.isAlive)
            gc.drawImage(blackrook2, g.board.blackRook2.graphicalX, g.board.blackRook2.graphicalY);
        if (g.board.blackPawn1.isAlive)
            gc.drawImage(blackpawn1, g.board.blackPawn1.graphicalX, g.board.blackPawn1.graphicalY);
        if (g.board.blackPawn2.isAlive)
            gc.drawImage(blackpawn2, g.board.blackPawn2.graphicalX, g.board.blackPawn2.graphicalY);
        if (g.board.blackPawn3.isAlive)
            gc.drawImage(blackpawn3, g.board.blackPawn3.graphicalX, g.board.blackPawn3.graphicalY);
        if (g.board.blackPawn4.isAlive)
            gc.drawImage(blackpawn4, g.board.blackPawn4.graphicalX, g.board.blackPawn4.graphicalY);
        if (g.board.blackPawn5.isAlive)
            gc.drawImage(blackpawn5, g.board.blackPawn5.graphicalX, g.board.blackPawn5.graphicalY);
        if (g.board.blackPawn6.isAlive)
            gc.drawImage(blackpawn6, g.board.blackPawn6.graphicalX, g.board.blackPawn6.graphicalY);
        if (g.board.blackPawn7.isAlive)
            gc.drawImage(blackpawn7, g.board.blackPawn7.graphicalX, g.board.blackPawn7.graphicalY);
        if (g.board.blackPawn8.isAlive)
            gc.drawImage(blackpawn8, g.board.blackPawn8.graphicalX, g.board.blackPawn8.graphicalY);

        if (g.currentPlayer == Black)
            gc.drawImage(blackmovessign, 1020, 400);

        if (g.currentPlayer == White)
            gc.drawImage(whitemovessign, 1020, 400);

        saveBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                g.saveGame("savedGame");
                theStage.hide();
                ChessGame m = new ChessGame();
                try {
                    m.start(theStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        drawBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                theStage.hide();

                try {
                    ChessGame m = new ChessGame();
                    m.start(theStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    g.modifyStats("Statistics.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        try {
            gameScene.setOnMouseClicked(new EventHandler<>() {
                boolean sourceCheck = true;
                boolean destCheck = false;
                double sourceX;
                double sourceY;
                Colour currentPlayerColour = g.currentPlayer;

                @Override
                public void handle(javafx.scene.input.MouseEvent event) {


                    if (sourceCheck && event.getX() <= 1000 && event.getY() <= 1000) {

                        sourceX = event.getX();
                        sourceY = event.getY();
                        if (g.board.board[(int) sourceY / 125][(int) sourceX / 125] == null)
                            return;
                        if (!g.board.board[(int) sourceY / 125][(int) sourceX / 125].colour.equals(currentPlayerColour)) {
                            System.out.println("You cant move your opponents figures");
                            return;
                        }
                        sourceCheck = false;
                        destCheck = true;

                    } else if (destCheck && event.getX() <= 1000 && event.getY() <= 1000) {
                        if (g.board.board[(int) sourceY / 125][(int) sourceX / 125].colour.equals(currentPlayerColour)) {
                            if (g.board.board[(int) sourceY / 125][(int) sourceX / 125].moveTo((int) event.getY() / 125, (int) event.getX() / 125)) {
                                sourceCheck = true;
                                destCheck = false;
                                if (currentPlayerColour == White) {
                                    currentPlayerColour = Black;
                                    g.currentPlayer = Black;
                                } else if (currentPlayerColour == Black) {
                                    currentPlayerColour = White;
                                    g.currentPlayer = Black;
                                }
                                g.moves++;
                            } else {
                                sourceCheck = true;
                                destCheck = false;
                            }
                        } else {
                            System.out.println("You cant move your opponents ");
                            sourceCheck = true;
                            destCheck = false;
                        }

                    }

                    if (!g.board.blackKing.isAlive) {

                        theStage.hide();
                        ChessGame m = new ChessGame();
                        try {
                            m.start(theStage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            g.modifyStats("Statistics.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    if (!g.board.whiteKing.isAlive) {

                        theStage.hide();
                        ChessGame m = new ChessGame();
                        try {
                            m.start(theStage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            g.modifyStats("Statistics.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    if (currentPlayerColour == Black)
                        gc.drawImage(blackmovessign, 1020, 400);

                    if (currentPlayerColour == White)
                        gc.drawImage(whitemovessign, 1020, 400);

                    gc.drawImage(board, 0, 0);

                    if (g.board.whiteRook1.isAlive)
                        gc.drawImage(whiterook1, g.board.whiteRook1.graphicalX, g.board.whiteRook1.graphicalY);
                    if (g.board.whiteHorse1.isAlive)
                        gc.drawImage(whitehorse1, g.board.whiteHorse1.graphicalX, g.board.whiteHorse1.graphicalY);
                    if (g.board.whiteBishop1.isAlive)
                        gc.drawImage(whitebishop1, g.board.whiteBishop1.graphicalX, g.board.whiteBishop1.graphicalY);
                    if (g.board.whiteKing.isAlive)
                        gc.drawImage(whiteking, g.board.whiteKing.graphicalX, g.board.whiteKing.graphicalY);
                    if (g.board.whiteQueen.isAlive)
                        gc.drawImage(whitequeen, g.board.whiteQueen.graphicalX, g.board.whiteQueen.graphicalY);
                    if (g.board.whiteBishop2.isAlive)
                        gc.drawImage(whitebishop2, g.board.whiteBishop2.graphicalX, g.board.whiteBishop2.graphicalY);
                    if (g.board.whiteHorse2.isAlive)
                        gc.drawImage(whitehorse2, g.board.whiteHorse2.graphicalX, g.board.whiteHorse2.graphicalY);
                    if (g.board.whiteRook2.isAlive)
                        gc.drawImage(whiterook2, g.board.whiteRook2.graphicalX, g.board.whiteRook2.graphicalY);
                    if (g.board.whitePawn1.isAlive)
                        gc.drawImage(whitepawn1, g.board.whitePawn1.graphicalX, g.board.whitePawn1.graphicalY);
                    if (g.board.whitePawn2.isAlive)
                        gc.drawImage(whitepawn2, g.board.whitePawn2.graphicalX, g.board.whitePawn2.graphicalY);
                    if (g.board.whitePawn3.isAlive)
                        gc.drawImage(whitepawn3, g.board.whitePawn3.graphicalX, g.board.whitePawn3.graphicalY);
                    if (g.board.whitePawn4.isAlive)
                        gc.drawImage(whitepawn4, g.board.whitePawn4.graphicalX, g.board.whitePawn4.graphicalY);
                    if (g.board.whitePawn5.isAlive)
                        gc.drawImage(whitepawn5, g.board.whitePawn5.graphicalX, g.board.whitePawn5.graphicalY);
                    if (g.board.whitePawn6.isAlive)
                        gc.drawImage(whitepawn6, g.board.whitePawn6.graphicalX, g.board.whitePawn6.graphicalY);
                    if (g.board.whitePawn7.isAlive)
                        gc.drawImage(whitepawn7, g.board.whitePawn7.graphicalX, g.board.whitePawn7.graphicalY);
                    if (g.board.whitePawn8.isAlive)
                        gc.drawImage(whitepawn8, g.board.whitePawn8.graphicalX, g.board.whitePawn8.graphicalY);


                    if (g.board.blackRook1.isAlive)
                        gc.drawImage(blackrook1, g.board.blackRook1.graphicalX, g.board.blackRook1.graphicalY);
                    if (g.board.blackHorse1.isAlive)
                        gc.drawImage(blackhorse1, g.board.blackHorse1.graphicalX, g.board.blackHorse1.graphicalY);
                    if (g.board.blackBishop1.isAlive)
                        gc.drawImage(blackbishop1, g.board.blackBishop1.graphicalX, g.board.blackBishop1.graphicalY);
                    if (g.board.blackKing.isAlive)
                        gc.drawImage(blackking, g.board.blackKing.graphicalX, g.board.blackKing.graphicalY);
                    if (g.board.blackQueen.isAlive)
                        gc.drawImage(blackqueen, g.board.blackQueen.graphicalX, g.board.blackQueen.graphicalY);
                    if (g.board.blackBishop2.isAlive)
                        gc.drawImage(blackbishop2, g.board.blackBishop2.graphicalX, g.board.blackBishop2.graphicalY);
                    if (g.board.blackHorse2.isAlive)
                        gc.drawImage(blackhorse2, g.board.blackHorse2.graphicalX, g.board.blackHorse2.graphicalY);
                    if (g.board.blackRook2.isAlive)
                        gc.drawImage(blackrook2, g.board.blackRook2.graphicalX, g.board.blackRook2.graphicalY);
                    if (g.board.blackPawn1.isAlive)
                        gc.drawImage(blackpawn1, g.board.blackPawn1.graphicalX, g.board.blackPawn1.graphicalY);
                    if (g.board.blackPawn2.isAlive)
                        gc.drawImage(blackpawn2, g.board.blackPawn2.graphicalX, g.board.blackPawn2.graphicalY);
                    if (g.board.blackPawn3.isAlive)
                        gc.drawImage(blackpawn3, g.board.blackPawn3.graphicalX, g.board.blackPawn3.graphicalY);
                    if (g.board.blackPawn4.isAlive)
                        gc.drawImage(blackpawn4, g.board.blackPawn4.graphicalX, g.board.blackPawn4.graphicalY);
                    if (g.board.blackPawn5.isAlive)
                        gc.drawImage(blackpawn5, g.board.blackPawn5.graphicalX, g.board.blackPawn5.graphicalY);
                    if (g.board.blackPawn6.isAlive)
                        gc.drawImage(blackpawn6, g.board.blackPawn6.graphicalX, g.board.blackPawn6.graphicalY);
                    if (g.board.blackPawn7.isAlive)
                        gc.drawImage(blackpawn7, g.board.blackPawn7.graphicalX, g.board.blackPawn7.graphicalY);
                    if (g.board.blackPawn8.isAlive)
                        gc.drawImage(blackpawn8, g.board.blackPawn8.graphicalX, g.board.blackPawn8.graphicalY);
                }


            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        theStage.show();
    }


}