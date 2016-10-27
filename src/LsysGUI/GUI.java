package LsysGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MasterWillis on 11/10/2016.
 */
public class GUI extends JPanel {

    public GUI() {
        System.out.println("GUI is on");
        Color heavenColor = new Color(99, 125, 150);


        //the mainFrame:
        JFrame mainFrame = new JFrame("growing tree");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 600);
        mainFrame.setVisible(true);

        JPanel backgroundPanel = new JPanel();

        mainFrame.add(backgroundPanel);
        backgroundPanel.setBackground(heavenColor);


    }



}
