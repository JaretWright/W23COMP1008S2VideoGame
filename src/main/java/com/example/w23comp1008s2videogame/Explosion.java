package com.example.w23comp1008s2videogame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Explosion extends Sprite{
    private final int REFRESH_RATE = 10;
    private int currentCount;
    private int explosionIndex;

    private int[] spriteStartX;

    public Explosion(int posX, int posY) {
        super(new Image(Explosion.class.getResourceAsStream("images/fullExplosion2.png")),
                posX, posY, 100, 100, 0);
        explosionIndex = 0;
        spriteStartX = new int[]{0,170,330,520,710};
        currentCount = REFRESH_RATE;
    }

    /**
     * This method will override the one from the Sprite class.  It will
     * draw the explosion in the same position each time.
     * Every 5 clock cycles of the animation timer, it will draw a new stage of the
     * explosion
     * After the last stage, it will set the alive status to false.
     */
    public void draw(GraphicsContext gc)
    {
        if (--currentCount < 0)
        {
            explosionIndex++;
            currentCount = REFRESH_RATE;
        }

        if (explosionIndex>=spriteStartX.length)
        {
            setAlive(false);
        }
        else {
            //image, sx, sy, sw, sh, posX, posY, imageWidth, imageHeight
            gc.drawImage(this.getImage(), spriteStartX[explosionIndex],0,184,368,posX,posY,imageWidth,
                    imageHeight);
        }
    }
}
