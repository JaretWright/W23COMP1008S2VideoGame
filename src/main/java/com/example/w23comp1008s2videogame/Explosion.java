package com.example.w23comp1008s2videogame;

import javafx.scene.image.Image;

public class Explosion extends Sprite{

    public Explosion(int posX, int posY) {
        super(new Image(Explosion.class.getResourceAsStream("images/fullExplosion2.png")),
                posX, posY, 100, 100, 0);
    }
}
