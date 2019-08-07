package swingy.views;

import swingy.models.Hero;

public class Show {
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

    public static void askHeroName() {
        System.out.print(
            "\n" +
            "What is your character's name: "
        );
    }

    public static void askHeroClass() {
        System.out.print(
            "\n" +
            "To which class will your new character belong: "
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
    }

    public static void displayStats(Hero hero) {
        System.out.print(
            "Hero Name:\t" + hero.name + "\n" +
            "Hero Class:\t" + hero.fighterType + "\n" +
            "Max Hit Points:\t" + hero.maxHitPoints + "\n" +
            "Defence:\t" + hero.defence + "\n" +
            "Attack:\t" + hero.attack + "\n" +
            "Level:\t" + hero.level + "\n" +
            "Exp:\t" + hero.exp + "\n"
        );
        if (hero.helm != null) {
            System.out.print(
                "Helm:\t" + hero.helm + "\n" +
                "Helm Hit Points Buff:\t" + hero.helm.buff + "\n"
            );
        }
        if (hero.armour != null) {
            System.out.print(
                "Armour:\t" + hero.armour + "\n" +
                "Armour Defence Buff:\t" + hero.armour.buff + "\n"
            );
        }
        if (hero.weapon != null) {
            System.out.print(
                "Weapon:\t" + hero.weapon + "\n" +
                "Weapon Attack Buff:\t" + hero.weapon.buff + "\n"
            );
        }
    }
}