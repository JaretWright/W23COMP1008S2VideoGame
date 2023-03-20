package com.example.w23comp1008s2videogame;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class GameBoardController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button startButton;

    @FXML
    void startGame(ActionEvent event) {
        startButton.setVisible(false);

        //a canvas can be used to "draw" on.  The GraphicsContext is a tool used for
        //the drawing
        Canvas canvas = new Canvas(GameConfig.getGame_width(),GameConfig.getGame_height());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //get an Image object
        Image shipImage = new Image(getClass().getResourceAsStream("images/ship.png"));
        Image background = new Image(getClass().getResourceAsStream("images/space.png"));

        Sprite ship = new Sprite(shipImage,400, 100,100,70,10);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.drawImage(background,0,0,GameConfig.getGame_width(),GameConfig.getGame_height());
                ship.draw(gc);
                ship.moveRight();
            }
        };
        timer.start();

        anchorPane.getChildren().add(canvas);
    }

}
