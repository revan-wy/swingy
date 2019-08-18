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

public class Swingy {
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

        return new Hero(name, heroClass, 0);
    }

    static void failure() {
        Show.lost();
        System.exit(1);
    }
    
    static boolean fight(Hero hero) {
        // Villian.getRandomVillian(hero);
        Villian villian = Villian.getRandomVillian(hero);
        Show.villianAppeared(villian);
        if (hero.run(villian)) {
            return false;
        }
        if (villian.statSum() > hero.statSum()) {
            Swingy.failure();
            return true;
        } else {
            Show.villianDefeated(villian);
            hero.gainExp(villian);
            return true;
        } 
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

    public static void main (String[] args) {
        setDisplayType(args);
        Hero hero = setup();
        Show.displayStats(hero);
        // if (!Gui.useGui) {
        //     Show.pressReturn();
        // }
        Map.createMap(hero);
        while (true) {
            // Show.heroPos();
            Show.mapSizeAndPos();
            Map.moveHero();
            if (Map.encounterVillian()) {
                if (fight(hero)) {
                    Artifact artifact = new Artifact(hero);
                    if (artifact.buff != 0 && hero.takeArtifact(artifact)) {
                        hero.equipArtifact(artifact);
                    }
                }
            }
        }
    }

    static void setDisplayType(String[] args) {
        String input = args[0].toUpperCase();
        if (input.equals("GUI")) {
            Gui.useGui = true;
            Gui.showtime();
        }
    }
    
    public static Hero setup () {
        String input = "";
        
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

    public static void victory() {
        Show.won();
        System.exit(1);
    }

}