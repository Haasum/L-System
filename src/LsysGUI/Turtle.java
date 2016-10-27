package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import static java.lang.System.out;

/**
 * Created by MasterWillis on 11/10/2016.
 */
public class Turtle {

    Grammatik grammatik;
    int growIs = 0;
    char c = 'A';

    public Turtle(Grammatik grammatik, RecursiveLsys lsys) {
        this.grammatik = grammatik;
     drawTurtle();
    }

    public void drawTurtle() {
       System.out.println(growIs = grammatik.getGrow('A'));
    }

    public void setGrowIs(char c) {

        growIs = grammatik.setGrow(c);
    }

    public int getGrowIs() {
        return growIs;
    }

}
