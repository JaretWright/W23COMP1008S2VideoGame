package com.example.w23comp1008s2videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Missile extends Sprite {

    public Missile(int posX, int posY) {
        super(new Image(Main.class.getResourceAsStream("images/missile.png")), posX, posY,
                40, 20, 7);
    }

    private void moveRight()
    {
        posX += speed;

        if (posX > GameConfig.getGame_width())
            setAlive(false);
    }

    public void draw(GraphicsContext gc)
    {
        super.draw(gc);
        moveRight();
    }
}
