package com.company;

import LsysRecursive.Grammatik;
import LsysRecursive.txt;

import javax.swing.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        //System.out.println("Main is ON");
        txt test = new txt();
        String txtFile = test.getTxtFile();
        //System.out.println("text file is " + txtFile);

        new Grammatik(txtFile);

        //new LsysGUI.GUI(); - udkommenteret for testing purposes


    }
}
