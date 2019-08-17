package swingy.views;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public static boolean useGui = false;
    
    public static void showtime() {

        //Creating the Frame
        JFrame frame = new JFrame("Revan-wy's Swingy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Type here");
        JTextField tf = new JTextField(30); // accepts upto 10 characters
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
}
