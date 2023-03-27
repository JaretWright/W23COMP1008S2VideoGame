package com.example.w23comp1008s2videogame;

import static org.junit.Assert.*;

public class ShipTest {

    private Ship ship;

    @org.junit.Before
    public void setUp() throws Exception {
         ship = new Ship(100,100,10);
    }

    @org.junit.Test
    public void moveRight() {
        ship.moveRight();
        assertEquals(110, ship.getPosX());
    }

    @org.junit.Test
    public void moveRightToEndOfScreen() {
        for (int i=0;i<=100;i++)
            ship.moveRight();
        assertEquals(900, ship.getPosX());
    }

    @org.junit.Test
    public void moveLeft() {
    }

    @org.junit.Test
    public void moveUp() {
    }

    @org.junit.Test
    public void moveDown() {
    }
}