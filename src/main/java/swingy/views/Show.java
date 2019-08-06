package swingy.views;

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
}