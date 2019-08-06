package swingy.controllers;

import swingy.models.FighterClass;
import swingy.models.Hero;
import swingy.views.*;

public class Game {
    public static void main (String[] args) {
        Hero hero = setup();
        // add here what to do with input and how to proceed


    }

    public static Hero setup () {
        String input = "";
        // String create = "create";
        // String load = "load";
        
        while (!(input.equals("CREATE") || input.equals("LOAD"))) {
            Show.initialScreen();
            input = GetInput.read();
            // System.out.println(input.equals("create") || input.equals("load"));
            // if (input.equals("create") || input.equals("load")) {
            //     break;
            // }
        }

        switch(input) {
            case "CREATE":
                return createNewHero();
            case "LOAD":
                System.out.println("This feature will be implemented at a later stage.");
                return new Hero();
                // return loadHero();
            default:
                return createNewHero();
        }
    }

    public static Hero createNewHero() {
        String name = "";
        String heroClass = "";
        
        Show.askHeroName();
        name = GetInput.read();

        while (!(FighterClass.contains(heroClass))) {
            Show.askHeroClass();
            heroClass = GetInput.read();
        }

        // public String name;
        // public FighterClass fighterClass;
        return new Hero(name, heroClass);
    }

    // public static Hero loadHero() {

    // }
}