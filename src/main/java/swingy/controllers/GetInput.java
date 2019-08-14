package swingy.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import swingy.views.Show;

public class GetInput {
    static BufferedReader br;

    public static void makeBr() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }


    public static String read() {
        String input;
        if (br == null) {
            makeBr();
        }
        try {
            input = br.readLine();
            return input.toUpperCase();
        } catch (IOException e) {
            Show.readIOException();
            System.exit(1);
            return "";
        }

    }
}