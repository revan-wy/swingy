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
        String output = 
            "\n" + 
            "Specify save file" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }
    
    public static void artifactDropped() {
        String output = 
            "\n" + 
            "An artifact has been dropped." + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
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
            "           Rogue   Thief   Soldier" + "\n" +
            "Hit Points   80      80      160"   + "\n" +
            "Defence      80     160       80"   + "\n" +
            "Attack      160      80       80"   + "\n"
        );
        GetInput.read();
    }

    public static void chooseDirection() {
        System.out.print(
            "\n" + 
            "Choose a compass direction to head in: "
        );
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
        System.out.print(
            "\n" + 
            "Artifact Type: \t" + artifact.artifactType + "\n"
        );
        System.out.print(
            affectedStat + " Bonus: \t" + artifact.buff + "\n"
        );
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
        System.out.print(
            "\n" + 
            "Do you want to equip this artifact? YES/NO "
        );
    }
    
    public static void fightOrRun() {
        System.out.print(
            "\n" + 
            "Do you want to fight or try to run away? FIGHT/RUN "
        );
    }
    
    public static void fileNotFoundException() {
        System.out.print(
            "\n" + 
            "Couldn't find file save.txt" + "\n"
        );
        GetInput.read();
    }
    
    public static void gainedExp(double exp, Hero hero) {
        System.out.print(
            "\n" + 
            hero.name + " has gained " + (int)exp + " experience points." + "\n"
        );
    }
    
    public static void heroPos() {
        System.out.print(
            "\n" + 
            "Hero position: " + x + "," + y + "\n"
        );
        GetInput.read();
    }

    public static void initialScreen() {
        String output = 
            "\n" +
            "\n" +
            "WELCOME!!!\n" +
            "\n" +
            "Enter CREATE to create a new character.\n" +
            "Enter LOAD to load an existing character.\n" +
            "Now, choose: "
        ;
        
        if (Gui.useGui == false) {
            System.out.print(output);
        } else {
            Gui.print(output);
        }
    }                                        

    public static void iOException() {
        System.out.print(
            "\n" + 
            "There was an error while reading the file save.txt" + "\n"
        );
        GetInput.read();
    }

    public static void leveledUp(Hero hero) {
        System.out.print(
            "\n" + 
            hero.name + " has gained a level." + "\n"
        );
    }
    
    public static void lost() {
        System.out.print(
            "\n" + 
            "You've lost" + "\n"
        );
        GetInput.read();
    }
    
    public static void mapSizeAndPos() {
        System.out.print(
            "\n" + 
            "Map size: " + Map.size + "\n"
        );
        System.out.print(
            "Hero position: " + x + "," + y + "\n"
        );
        GetInput.read();
    }

    public static void pressReturn() {
        System.out.print(
            "\n" + 
            "Press RETURN to start game" + "\n"
        );
        GetInput.read();
    }

    public static void readIOException() {
        System.out.print(
            "\n" + 
            "Reading input failed" + "\n"
        );
        GetInput.read();
    }

    public static void runFail() {
        System.out.print(
            "\n" + 
            "Your escape attempt failed. Now, FIGHT!" + "\n"
        );
    }
    
    public static void runSuccess(Villian villian) {
        System.out.print(
            "\n" + 
            "You've managed to escape from the " + villian.fighterType + ".\n"
        );
    }
    
    public static void villianAppeared(Villian villian) {
        System.out.print(
            "\n" + 
            "A wild " + villian.fighterType + " appeared!"+ "\n"
        );
        GetInput.read();
    }

    public static void villianDefeated(Villian villian) {
        System.out.print(
            "\n" + 
            "You've defeated the " + villian.fighterType + ".\n"
        );
        GetInput.read();
    }
    
    public static void won() {
        System.out.print(
            "\n" + 
            "You've won" + "\n"
        );
        GetInput.read();
    }
}