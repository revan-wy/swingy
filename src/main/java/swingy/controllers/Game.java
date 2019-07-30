package swingy.controllers;

import swingy.models.GetInput;
import swingy.views.*;

public class Game {
    public static void main (String[] args) {
        String input;
        Show.initialScreen();
        input = GetInput.read();
        System.out.println(input);
        // add here what to do with input and how to proceed
    }
}