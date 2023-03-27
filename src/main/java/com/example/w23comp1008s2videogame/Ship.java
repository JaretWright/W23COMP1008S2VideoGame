package com.example.w23comp1008s2videogame;

import javafx.scene.image.Image;

public class Ship extends Sprite {

    /**
     * The ship image will always be the same ship, so we do not need to pass that in as a parameter
     * The size of the ship will be 100x70, so no need to pass those arguments in anymore
     * @param posX
     * @param posY
     * @param speed
     */
    public Ship(int posX, int posY, int speed) {
        super(new Image(Main.class.getResourceAsStream("images/ship.png")), posX, posY,
                100, 70, speed);
    }
}
