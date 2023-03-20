package com.example.w23comp1008s2videogame;

public class GameConfig {
    private static int game_width = 1000;
    private static int game_height = 800;

    public static int getGame_width() {
        return game_width;
    }

    public static void setGame_width(int game_width) {
        if (game_width>=200 && game_width <= 1400)
            GameConfig.game_width = game_width;
        else
            throw new IllegalArgumentException("game width must be 200-1400");
    }

    public static int getGame_height() {
        return game_height;
    }

    public static void setGame_height(int game_height) {
        if (game_height>=100 && game_height<=1080)
            GameConfig.game_height = game_height;
        else
            throw new IllegalArgumentException("game height must be in the range 100-1080");
    }
}
