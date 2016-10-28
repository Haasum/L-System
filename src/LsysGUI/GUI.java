package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;


/**
 * GUI står for at lave vores interface, vinduet som skal tegnes på af turtlen osv.
 *
 */
public class GUI extends JFrame {

Turtle turtle;
    Grammatik grammatik;
    RecursiveLsys lsys;
    static JPanel mainPanel = new JPanel();

    public GUI() {

        Turtle turtle = new Turtle(grammatik, lsys);

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




