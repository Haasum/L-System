package com.company;

import LsysGUI.Turtle;
import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;
import LsysRecursive.txt;

/**
 * Created by nanna on 25-10-2016.
 */
public class Controller {

    /**
     * Controller skal stå for at styre alle de andre klasser som en superclass, dog med nogen undtagelser
     */

    public Controller(){

        //System.out.println("Main is ON");
        txt test = new txt();
        String txtFile = test.getTxtInput();
        //System.out.println("text file is " + txtFile);

        Grammatik grammatik = new Grammatik(txtFile);
        RecursiveLsys lsys = new RecursiveLsys(grammatik);

        new LsysGUI.GUI();


    }


}
