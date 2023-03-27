package com.example.w23comp1008s2videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Alien extends Sprite{
    /**
     * This is the constructor for the Sprite class
     *
     * @param posX        - the left most position of the Sprite
     * @param posY        - the top positon of the Sprite
     *
     */
    public Alien(int posX, int posY) {
        super(new Image(Main.class.getResourceAsStream("images/alien.png")), posX, posY,
                60, 60, 3);
    }

    private void moveLeft()
    {
        posX = posX-speed;

        if (posX<0-imageWidth)
            posX=GameConfig.getGame_width();
    }

    public void draw(GraphicsContext gc)
    {
        super.draw(gc);
        moveLeft();
    }
}
