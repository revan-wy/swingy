package swingy.models;

import static swingy.models.Coordinates.x;
import static swingy.models.Coordinates.y;

public class Map {
    public static int size;
    public static Coordinates coordinates;

    public static void createMap(Hero hero) {
        size = (hero.level - 1) * 5 + 10 - (hero.level % 2);
        x = (size + 1) / 2;
        y = x;
    }
}