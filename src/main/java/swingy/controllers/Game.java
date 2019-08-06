package swingy.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import swingy.models.FighterTypes;
import swingy.models.Hero;
import swingy.views.*;

public class Game {
    public static void main (String[] args) {
        Hero hero = setup();
        System.out.print(
            "att\t" + hero.attack + "\n" +
            "def\t" + hero.defence + "\n" +
            "exp\t" + hero.exp + "\n" +
            "mhp\t" + hero.maxHitPoints + "\n" +
            "rhp\t" + hero.remainingHitPoints + "\n" +
            "lvl\t" + hero.level + "\n" +
            "nm\t" + hero.name + "\n" +
            "fc\t" + hero.fighterType + "\n"
        );

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
                return loadExistingHero();
                // System.out.println("This feature will be implemented at a later stage.");
                // return new Hero();
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

        while (!(FighterTypes.contains(heroClass))) {
            Show.classLevelZeroDetails();
            Show.askHeroClass();
            heroClass = GetInput.read();
        }

        // public String name;
        // public FighterClass fighterClass;
        return new Hero(name, heroClass, 0);
    }

    private static Hero loadExistingHero() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
            String line = reader.readLine();
            if (line != null) {
                reader.close();
                return new Hero(line.split(" ")[0].toUpperCase(), line.split(" ")[1].toUpperCase(),
                Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]));
            }
            reader.close();
            return createNewHero();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file save.txt");
            return createNewHero();
        } catch (IOException e) {
            System.out.println("There was an error while reading the file save.txt");
            return createNewHero();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify save file");
            return createNewHero();
        } 

    }
}