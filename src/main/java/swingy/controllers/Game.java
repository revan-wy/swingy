package swingy.controllers;

import swingy.models.GetInput;
import swingy.views.*;

public class Game {
    public static void main (String[] args) {
        setup();
        // add here what to do with input and how to proceed


    }

    public static void setup () {
        String input = "";
        // String create = "create";
        // String load = "load";
        
        while (!(input.equals("create") || input.equals("load"))) {
            Show.initialScreen();
            input = GetInput.read();
            // System.out.println(input.equals("create") || input.equals("load"));
            // if (input.equals("create") || input.equals("load")) {
            //     break;
            // }
        }
    }
}