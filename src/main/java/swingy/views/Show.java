package swingy.views;

import static swingy.models.Coordinates.x;
import static swingy.models.Coordinates.y;

import swingy.controllers.GetInput;
import swingy.models.Artifact;
import swingy.models.Hero;
import swingy.models.Map;
import swingy.models.Villian;

public class Show {
    public static void arrayIndexOutOfBoundsException() {
        System.out.println("Specify save file");
        GetInput.read();
    }
    
    public static void artifactDropped() {
        System.out.print("\nAn artifact has been dropped.\n");
        GetInput.read();
    }
    
    public static void askHeroClass() {
        System.out.print(
            "\n" +
            "To which class will your new character belong: "
        );
    }

    public static void askHeroName() {
        System.out.print(
            "\n" +
            "What is your character's name: "
        );    
    }    

    public static void classLevelZeroDetails() {
        System.out.print(
            "\n" +
            "           Rogue   Thief   Soldier" +  "\n" +
            "Hit Points   80      80      160" + "\n" +
            "Defence      80     160       80" + "\n" +
            "Attack      160      80       80" +  "\n"
        );
        GetInput.read();
    }

    public static void chooseDirection() {
        System.out.print("\nChoose a compass direction to head in: "); // 
    }
    
    public static void displayStats(Artifact artifact) {
        String affectedStat = "";
        switch(artifact.artifactType) {
            case ARMOUR:
                affectedStat = "Defence";
                break;
            case WEAPON:
                affectedStat = "Attack";
                break;
            case HELM:
                affectedStat = "Hit Points";
                break;
        }
        System.out.print("\nArtifact Type: \t" + artifact.artifactType + "\n");
        System.out.print(affectedStat + " Bonus: \t" + artifact.buff + "\n");
        GetInput.read();
    }

    public static void displayStats(Hero hero) {
        System.out.print(
            "\n" +
            "Hero Name:\t" + hero.name + "\n" +
            "Hero Class:\t" + hero.fighterType + "\n" +
            "Max Hit Points:\t" + hero.maxHitPoints + "\n" +
            "Defence:\t" + hero.defence + "\n" +
            "Attack:\t\t" + hero.attack + "\n" +
            "Level:\t\t" + hero.level + "\n" +
            "Exp:\t\t" + hero.exp + "\n"
        );    
        if (hero.helm != null) {
            System.out.print(
                "Artifact:\t" + hero.helm.artifactType + "\n" +
                "Helm Hit Points Buff: " + hero.helm.buff + "\n"
            );    
        }    
        if (hero.armour != null) {
            System.out.print(
                "Artifact:\t" + hero.armour.artifactType + "\n" +
                "Armour Defence Buff: " + hero.armour.buff + "\n"
            );    
        }    
        if (hero.weapon != null) {
            System.out.print(
                "Artifact:\t" + hero.weapon.artifactType + "\n" +
                "Weapon Attack Buff: " + hero.weapon.buff + "\n"
            );    
        }    
        GetInput.read();
    }        
    
    public static void equipAsk() {
        System.out.print("\nDo you want to equip this artifact? YES/NO "); // move this code to VIEW
    }
    
    public static void fightOrRun() {
        System.out.print("\nDo you want to fight or try to run away? FIGHT/RUN ");
    }
    
    public static void fileNotFoundException() {
        System.out.println("Couldn't find file save.txt");
        GetInput.read();
    }
    
    public static void heroPos() {
        System.out.print("\nHero position: " + x + "," + y + "\n"); // put these two lines in VIEW method
        GetInput.read();
    }

    public static void initialScreen() {
        System.out.print(
            "\n" +
            "\n" +
            "WELCOME!!!\n" +
            "\n" +
            "Enter CREATE to create a new character.\n" +
            "Enter LOAD to load an existing character.\n" +
            "Now, choose: ");
    }                                        

    public static void iOException() {
        System.out.println("There was an error while reading the file save.txt");
        GetInput.read();
    }

    public static void lost() {
        System.out.print("You've lost\n");
        GetInput.read();
    }
    
    public static void mapSizeAndPos() {
        System.out.print("\nMap size: " + Map.size + "\n");
        System.out.print("Hero position: " + x + "," + y + "\n");
        GetInput.read();
    }

    public static void pressReturn() {
        System.out.print("\nPress RETURN to start game");
        GetInput.read();
    }

    public static void readIOException() {
        System.out.println("Reading input failed");
        GetInput.read();
    }

    public static void runFail() {
        System.out.print("\nYour escape attempt failed. Now, FIGHT!\n");
    }
    
    public static void runSuccess(Villian villian) {
        System.out.print("\nYou've managed to escape from the " + villian.fighterType + ".\n");
    }
    
    public static void villianAppeared(Villian villian) {
        System.out.print("\nA wild " + villian.fighterType + " appeared!\n");
        GetInput.read();
    }

    public static void villianDefeated(Villian villian) {
        System.out.print("\nYou've defeated the " + villian.fighterType + ".\n");
        GetInput.read();
    }
    
    public static void won() {
        System.out.print("\nYou've won\n");
        GetInput.read();
    }
}