package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;


/**
 * Created by MasterWillis on 11/10/2016.
 */
public class GUI extends JFrame {

Turtle turtle;
    Grammatik grammatik;
    RecursiveLsys lsys;
Color heavenColor = new Color(99, 125, 150);
    static JPanel mainPanel = new JPanel();

    public GUI() {

        Turtle turtle = new Turtle(grammatik, lsys);
        System.out.println("GUI is on");
        //Color heavenColor = new Color(99, 125, 150);

        setTitle("Growing Tree");
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        drawMainPanel();

    }
    public void drawMainPanel() {
        //the mainPanel:
        add(mainPanel);
        mainPanel.setSize(600, 600);
        mainPanel.setVisible(true);
        mainPanel.setBackground(null);
        mainPanel.setLayout(null);
        //mainPanel.add(turtle);
    }



    }




