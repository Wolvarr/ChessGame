package homework;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The ChessGame program is an application, where
 * two player can play chess again each other
 * int the same device
 *
 * @author Richard Pasics
 * @version 1.0
 * @since 2018-11-22
 */
public class ChessGame extends Application {



    /**
     * The main method of the program, starts this class's start method
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * The start method of the program, it is responsible for
     * all the graphics displayed during the life
     * of the application.
     *
     * @param stage The stage to display graphics on
     */
    @Override
    public void start(Stage stage) {


        stage.setTitle("Main menu");

        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);


        Image background = new Image("background.png");

        Button newGameBt = new Button("Start new game");
        newGameBt.setMinSize(700, 100);
        newGameBt.setTranslateX(300);
        newGameBt.setTranslateY(10);
        newGameBt.setStyle("-fx-font: 32 arial;");


        Button serializeBt = new Button("Continue last game");
        serializeBt.setMinSize(700, 100);
        serializeBt.setTranslateX(300);
        serializeBt.setTranslateY(10);
        serializeBt.setStyle("-fx-font: 32 arial;");

        Button statBt = new Button("Open Statistics");
        statBt.setMinSize(700, 100);
        statBt.setTranslateX(300);
        statBt.setTranslateY(10);
        statBt.setStyle("-fx-font: 32 arial;");

        Button closeBt = new Button("Exit");
        closeBt.setMinSize(700, 100);
        closeBt.setTranslateX(300);
        closeBt.setTranslateY(10);
        closeBt.setStyle("-fx-font: 32 arial;");

        Canvas canvas = new Canvas(1300, 195);
        root.getChildren().addAll(canvas, newGameBt, serializeBt, statBt, closeBt);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(background, 0, 0);
        Scene scene = new Scene(root, 1300, 700);
        stage.setScene(scene);
        stage.show();


        newGameBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.hide();
                Game_mechanism currentGame = new Game_mechanism();
                currentGame.start(stage);
                stage.show();

            }
        });
        closeBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();

            }
        });

        serializeBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.hide();
                Game_mechanism currentGame = new Game_mechanism();
                currentGame.g.loadGame("savedGame");
                currentGame.start(stage);
                stage.show();
            }
        });

        statBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game_mechanism currentGame = new Game_mechanism();
                FlowPane rooot = new FlowPane();
                Stage tmpstage = new Stage();
                tmpstage.setTitle("Statistics");
                tmpstage.setScene(new Scene(rooot, 450, 450));

                TextArea statText = new TextArea("Statistics");

                rooot.getChildren().add(statText);
                statText.setTranslateX(0);
                statText.setTranslateY(0);
                statText.setMinSize(450, 450);
                statText.setEditable(false);

                // Hide this current window (if this is what you want)


                try {
                    int datas[] = currentGame.g.getStats("Statistics.txt");
                    statText.setText("\n\n\n     Number of matches recorded: " + datas[0]
                            + "\n     Average moves: " + datas[1] + "\n     White wins: " + datas[2] + "\n     Black Wins: " + datas[3] + "\n     Draws: " + datas[4]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                statText.setStyle("-fx-font: 24 arial;");
                tmpstage.show();
            }

        });


        stage.show();


    }

}