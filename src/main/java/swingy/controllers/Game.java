package swingy.controllers;

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
        Show.pressReturn();
        Map.createMap(hero);
        Show.mapSizeAndPos();
        while (true) {
            Map.moveHero();
            Show.heroPos();
            if (Map.encounterVillian()) {
                fight(hero);
                Artifact artifact = new Artifact(hero);
                if (artifact.buff != 0 && hero.takeArtifact(artifact)) {
                    hero.equipArtifact(artifact);
                }
            }
        }
    }

    public static Hero setup () {
        String input = "";
        // String create = "create";
        // String load = "load";
        
        while (!(input.equals("CREATE") || input.equals("LOAD"))) {
            Show.initialScreen();
            input = GetInput.read();
        }

        switch(input) {
            case "CREATE":
                return createNewHero();
            case "LOAD":
                return loadExistingHero();
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
            Show.fileNotFoundException();
            return createNewHero();
        } catch (IOException e) {
            Show.iOException();
            return createNewHero();
        } catch (ArrayIndexOutOfBoundsException e) {
            Show.arrayIndexOutOfBoundsException();
            return createNewHero();
        } 

    }

    public static void victory() {
        Show.won();
        System.exit(1);
    }

    static void fight(Hero hero) {
        // Villian.getRandomVillian(hero);
        Villian villian = Villian.getRandomVillian(hero);
        Show.villianAppeared(villian);
        if (villian.statSum() > hero.statSum()) {
            Game.failure();
            // return false;
        } else {
            Show.villianDefeated(villian);
        } 
    }

    static void failure() {
        Show.lost();
        System.exit(1);
    }
}