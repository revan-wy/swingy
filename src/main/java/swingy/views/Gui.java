package swingy.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui {
    public static boolean useGui = false;
    static JFrame frame;
    static JLabel outputArea;
    public static JTextField tf;
    public static boolean returnPress = false;
    static String outputString = "";
    
    static void print() {
        Gui.outputArea.setText(Gui.stringToHtml(outputString));
        outputString = "";
    }
    
    static void print(String string) {
        Gui.outputArea.setText(Gui.stringToHtml(string));
    }
    
    public static void showtime() {

        frame = new JFrame("Revan-wy's Swingy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);

        Action action = new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                returnPress = true;
            }
        };

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Type here");
        tf = new JTextField(30);
        tf.addActionListener(action);
        panel.add(label);
        panel.add(tf);

        outputArea = new JLabel();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, outputArea);
        frame.setVisible(true);
    }

    static String stringToHtml(String string) {
        return "<html><pre>" + string.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</pre></html>";
    }
}
