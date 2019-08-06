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
            "What is your character's name: "
        );
    }

    public static void askHeroClass() {
        System.out.print(
            "To which class will your new character belong: "
        );
    }
}