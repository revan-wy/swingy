package swingy.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import swingy.views.Gui;
import swingy.views.Show;

public class GetInput {
    static BufferedReader br;

    public static void makeBr() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }


    public static String read() {
        String input = "";
        if (!Gui.useGui) {
            if (br == null) {
                makeBr();
            }
            try {
                input = br.readLine();
            } catch(IOException e) {
                Show.readIOException();
                System.exit(1);
                return "";
            }
        } else {
            while (!Gui.returnPress) {
                input = Gui.tf.getText();
            } 
            Gui.returnPress = false;
            Gui.tf.setText("");
        }
        input = input.toUpperCase();
        Swingy.exit(input);
        return input.toUpperCase();
    }
}