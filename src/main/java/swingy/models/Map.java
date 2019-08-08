package swingy.models;

public class Map {
    public static int size;

    public static void setSize(Hero hero) {
        size = (hero.level - 1) * 5 + 10 - (hero.level % 2);
    }
}