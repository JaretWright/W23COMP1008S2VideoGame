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

    public void moveRight()
    {
        posX = posX + speed;
        if (posX > GameConfig.getGame_width()-imageWidth)
            posX = GameConfig.getGame_width()-imageWidth;
    }

    public void moveLeft()
    {
        posX = posX - speed;
        if (posX<0)
            posX=0;
    }

    /**
     * The highest the ship can be drawn is row 0.
     */
    public void moveUp()
    {
         posY -= speed;

         if (posY<0)
             posY=0;
    }

    /**
     * based on a 1000x800 game, the furthest down would be 800 minus the height of the ship image (70)
     * 800-70 = 730
     */
    public void moveDown()
    {
        int furthestDown = GameConfig.getGame_height()-imageHeight;
        posY += speed;

        if (posY > furthestDown)
            posY = furthestDown;
    }
}
