package swingy.models;

import static swingy.models.Coordinates.x;
import static swingy.models.Coordinates.y;

import java.util.Random;

import swingy.controllers.Game;
import swingy.controllers.GetInput;
import swingy.views.Show;

public class Map {
    public static int size;
    public static Coordinates coordinates;

    public static void createMap(Hero hero) {
        size = (hero.level - 1) * 5 + 10 - (hero.level % 2);
        x = (size + 1) / 2;
        y = x;
    }

    public static void moveHero() {
        Show.chooseDirection();
        switch(GetInput.read()) {
            case "NORTH":
                x = x - 1;
                break;
            case "SOUTH":
                x = x + 1;
                break;
            case "EAST":
                y = y + 1;
                break;
            case "WEST":
                y = y - 1;
                break;
        }
        if (x <= 0 || x > size || y <= 0 || y > size) {
            Game.victory();
        }
    }

    public static boolean encounterVillian() {
        Random random = new Random();
        if (random.nextDouble() < 0.66666) {
            return true;
        } else {
            return false;
        }
    }
}