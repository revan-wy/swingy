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
            "Specify save file" + "\n" +
            "Press RETURN" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.print(output);
        }
        GetInput.read();
    }
    
    public static void artifactDropped() {
        String output = 
            "\n" + 
            "An artifact has been dropped."
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.print(output);
        }
        GetInput.read();
    }
    
    public static void askHeroClass() {
        String output = 
            "\n" +
            "To which class will your new character belong: "
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.print(output);
        }
    }

    public static void askHeroName() {
        String output = 
            "\n" +
            "What is your character's name: "
        ;
        if (!Gui.useGui) {
            System.out.print(output);    
        } else {
            Gui.print(output);
        }
    }    

    public static void classLevelZeroDetails() {
        String output = 
            "\n" +
            "           Rogue   Thief   Soldier" + "\n" +
            "Hit Points   80      80      160"   + "\n" +
            "Defence      80     160       80"   + "\n" +
            "Attack      160      80       80"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.outputString = Gui.outputString + output;
        }
    }

    public static void chooseDirection() {
        String output = 
            "\n" + 
            "Choose a compass direction to head in: "
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.outputString = Gui.outputString + output;
            Gui.print();
        }
    }
    
    public static void displayStats(Artifact artifact) {
        String output;
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
        output = 
            "\n" + 
            "Artifact Type: \t" + artifact.artifactType
        ;
        output = output + 
            "\n" +
            affectedStat + " Bonus: \t" + artifact.buff
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }

    public static void displayStats(Hero hero) {
        String output =
            "\n" +
            "Hero Name:\t" + hero.name + "\n" +
            "Hero Class:\t" + hero.fighterType + "\n" +
            "Max Hit Points:\t" + hero.maxHitPoints + "\n" +
            "Defence:\t" + hero.defence + "\n" +
            "Attack:\t\t" + hero.attack + "\n" +
            "Level:\t\t" + hero.level + "\n" +
            "Exp:\t\t" + hero.exp
        ;
        if (hero.helm != null) {
            output = output +
                "\n" +
                "Artifact:\t" + hero.helm.artifactType + "\n" +
                "Helm Hit Points Buff: " + hero.helm.buff
            ;    
        }    
        if (hero.armour != null) {
            output = output + 
                "\n" +
                "Artifact:\t" + hero.armour.artifactType + "\n" +
                "Armour Defence Buff: " + hero.armour.buff
            ;    
        }    
        if (hero.weapon != null) {
            output = output + 
                "\n" +
                "Artifact:\t" + hero.weapon.artifactType + "\n" +
                "Weapon Attack Buff: " + hero.weapon.buff
            ;    
        }    
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }        
    
    public static void equipAsk() {
        String output = 
            "\n" + 
            "Do you want to equip this artifact? YES/NO "
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.print(output);
        }
    }
    
    public static void fightOrRun() {
        String output = 
            "\n" + 
            "Do you want to fight or try to run away? FIGHT/RUN "
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.outputString = Gui.outputString + output;
            Gui.print();
        }
    }
    
    public static void fileNotFoundException() {
        String output = 
            "\n" + 
            "Couldn't find file save.txt" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.outputString = Gui.outputString + output;
        }
    }
    
    public static void gainedExp(double exp, Hero hero) {
        String output = 
            "\n" + 
            hero.name + " has gained " + (int)exp + " experience points."
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }
    
    public static void heroPos() {
        String output = 
            "\n" + 
            "Hero position: " + x + "," + y + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
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
        String output = 
            "\n" + 
            "There was an error while reading the file save.txt" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.outputString = Gui.outputString + output;
        }
}

    public static void leveledUp(Hero hero) {
        String output = 
            "\n" + 
            hero.name + " has gained a level."
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }
    
    public static void lost() {
        String output = 
            "\n" + 
            "You've lost" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }
    
    public static void mapSizeAndPos() {
        String output = 
            "\n" + 
            "Map size: " + Map.size + "\n" +
            "Hero position: " + x + "," + y
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.outputString = Gui.outputString + output;
        }
    }

    public static void pressReturn() {
        String output = 
            "\n" + 
            "Press RETURN to start game" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }

    public static void readIOException() {
        String output = 
            "\n" + 
            "Reading input failed" + "\n"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }

    public static void runFail() {
        String output = 
            "\n" + 
            "Your escape attempt failed. Now, FIGHT!"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.print(output);
        }
    }
    
    public static void runSuccess(Villian villian) {
        String output = 
            "\n" + 
            "You've managed to escape from the " + villian.fighterType
        ;
        if (!Gui.useGui) {
            System.out.print(output);
        } else {
            Gui.outputString = Gui.outputString + output;
            // Gui.print(output);
        }
    }
    
    public static void villianAppeared(Villian villian) {
        String output = 
            "\n" + 
            "A wild " + villian.fighterType + " appeared!"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.outputString = Gui.outputString + output;
        }
    }

    public static void villianDefeated(Villian villian) {
        String output = 
            "\n" + 
            "You've defeated the " + villian.fighterType
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }
    
    public static void won() {
        String output = 
            "\n" + 
            "You've won"
        ;
        if (!Gui.useGui) {
            System.out.print(output);
            GetInput.read();
        } else {
            Gui.print(output);
        }
    }
}