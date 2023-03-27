package com.example.w23comp1008s2videogame;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;

public class GameBoardController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button startButton;

    private HashSet<KeyCode> activeKeys;

    @FXML
    void startGame(ActionEvent event) {
        startButton.setVisible(false);

        //create a HashSet to store the keys that are currently pressed
        //A HashSet is like an ArrayList except that it prevents duplicates
        //and it does not preserve the order of elements.  This is not a specific piece of knowledge
        //you need for this course, it is covered in the datastructure side of Advanced Java.  However,
        //employers have been known to ask about it during job interviews, so I'm giving you a sneak peak!
        activeKeys = new HashSet<>();

        //register when a key is pressed or released
        //When we use -> {} it is a "lambda expression".  Essentially, it is a shortcut way of creating an
        //anonymous inner class and calling a method
        anchorPane.getScene().setOnKeyPressed(keyPressed -> activeKeys.add(keyPressed.getCode()));
        anchorPane.getScene().setOnKeyReleased(keyReleased -> activeKeys.remove(keyReleased.getCode()));

        //a canvas can be used to "draw" on.  The GraphicsContext is a tool used for
        //the drawing
        Canvas canvas = new Canvas(GameConfig.getGame_width(),GameConfig.getGame_height());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //get an Image object
//        Image shipImage = new Image(getClass().getResourceAsStream("images/ship.png"));
        Image background = new Image(getClass().getResourceAsStream("images/space.png"));

//        Sprite ship = new Sprite(shipImage,100, 100,100,70,1);
        Ship ship = new Ship(100,100,4);

        //Create a collection of Aliens
        SecureRandom rng = new SecureRandom();
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i=1; i<= 10; i++)
        {
            //this gives a randon number between 500-1000 for the X
            //                                   0-800 for the Y
            aliens.add(new Alien(rng.nextInt(500,GameConfig.getGame_width()),
                                        rng.nextInt(GameConfig.getGame_height())));
        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.drawImage(background,0,0,GameConfig.getGame_width(),GameConfig.getGame_height());
                updateShip(ship);
                ship.draw(gc);

                for (Alien alien : aliens)
                    alien.draw(gc);
            }
        };
        timer.start();

        anchorPane.getChildren().add(canvas);
    }

    /**
     * This method will read from the activeKeys set to determine which methods from the Ship
     * class should be called
     */
    private void updateShip(Ship ship)
    {
        if (activeKeys.contains(KeyCode.LEFT))
            ship.moveLeft();
        if (activeKeys.contains(KeyCode.RIGHT))
            ship.moveRight();
        if (activeKeys.contains(KeyCode.UP))  //student goal - update the Ship class to handle up and down
            ship.moveUp();
        if (activeKeys.contains(KeyCode.DOWN))
            ship.moveDown();
        if (activeKeys.contains(KeyCode.SPACE))
            ship.shootMissile();
    }

}


/**
 *
 * ArrayList -> [A,A,A,A,A,A,A,A]
 * Stack -> push items onto the stack and pop them off.
 * Set -> Sets are much like list - they are a collection, however, they automatically prevent
 *              duplicates
 * [A]
 *
 *
 *
 *
 */