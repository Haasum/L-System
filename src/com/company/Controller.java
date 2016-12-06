package com.company;

import LsysGUI.Brugerinput;
import LsysGUI.StaticView;
import LsysGUI.Turtle;
import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;
import LsysRecursive.txt;

import java.io.IOException;

import static LsysGUI.StaticView.mainPanel;

/**
 * Created by nanna on 25-10-2016.
 */
public class Controller {

    /**
     * Controller skal stå for at styre alle de andre klasser som en superclass, dog med nogen undtagelser
     */

    String tree;
    Turtle turtle;
    StaticView staticView;
    Brugerinput brugerinput;


    public Controller() throws IOException {



        txt test = new txt();
        String txtFile = test.checkTxt();

        Grammatik grammatik = new Grammatik(txtFile);
        RecursiveLsys lsys = new RecursiveLsys(grammatik,"K",1);
        tree = lsys.getTree();
        System.out.println("Dette er træet, wuhuuuuuu "+tree);

        staticView = new StaticView(lsys);
        turtle = new Turtle("K", lsys);
        brugerinput = new Brugerinput(mainPanel, lsys);




    }




}
