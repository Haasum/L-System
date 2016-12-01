package com.company;

import LsysGUI.StaticView;
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

    String tree;

    public Controller(){



        txt test = new txt();
        String txtFile = test.getTxtInput();

        Grammatik grammatik = new Grammatik(txtFile);
        RecursiveLsys lsys = new RecursiveLsys(grammatik);
        tree = lsys.getTree();
        System.out.println("Dette er træet, wuhuuuuuu "+tree);

        StaticView staticView = new StaticView();




    }


}
