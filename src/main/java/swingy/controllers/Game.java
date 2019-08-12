package swingy.controllers;

import static swingy.models.Coordinates.x;
import static swingy.models.Coordinates.y;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import swingy.models.Artifact;
import swingy.models.FighterTypes;
import swingy.models.Hero;
import swingy.models.Map;
import swingy.models.Villian;
import swingy.views.*;

public class Game {
    public static void main (String[] args) {
        Hero hero = setup();
        Show.displayStats(hero);
        System.out.print("Press Return to start game");
        GetInput.read();
        Map.createMap(hero);
        System.out.print("Map size: " + Map.size + "\n");
        System.out.print("Hero position: " + x + "," + y + "\n");
        while (true) {
            Map.moveHero();
            if (Map.encounterVillian()) {
                fight(hero);
                Artifact artifact = new Artifact(hero);
                if (artifact.buff != 0 && hero.takeArtifact()) {
                    hero.equipArtifact(artifact);
                }
            }
        }

        // System.out.print(
        //     "att\t" + hero.attack + "\n" +
        //     "def\t" + hero.defence + "\n" +
        //     "exp\t" + hero.exp + "\n" +
        //     "mhp\t" + hero.maxHitPoints + "\n" +
        //     "rhp\t" + hero.remainingHitPoints + "\n" +
        //     "lvl\t" + hero.level + "\n" +
        //     "nm\t" + hero.name + "\n" +
        //     "fc\t" + hero.fighterType + "\n" +
        //     "hlm\t" + hero.helm + "\n" +
        //     "rmr\t" + hero.armour + "\n" +
        //     "wpn\t" + hero.weapon + "\n"
        // );

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

    public static void victory() {
        System.out.print("You've won\n");
        System.exit(1);
    }

    static void fight(Hero hero) {
        // Villian.getRandomVillian(hero);
        Villian villian = Villian.getRandomVillian(hero);
        if (villian.statSum() > hero.statSum()) {
            Game.failure();
            // return false;
        } // else {
            // return true;
        // } 
    }

    static void failure() {
        System.out.print("You've lost\n");
        System.exit(1);
    }
}