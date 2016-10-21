package com.company;

import LsysRecursive.Grammatik;
import LsysRecursive.txt;

import javax.swing.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        System.out.println("Test 2");
        txt test = new txt();
        String txtFile = test.getTxtFile();
      //Grammatik grammatik = new Grammatik(txtFile); //21. okt: denne kan udkommenteres, og så kører programmet.
        new LsysGUI.GUI();


    }
}
