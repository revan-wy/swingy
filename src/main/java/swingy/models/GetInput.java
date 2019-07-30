package swingy.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            return input.toLowerCase();
        } catch (IOException e) {
            System.out.println("Reading input failed");
            System.exit(1);
            return "";
        }

    }
}