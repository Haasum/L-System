package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

/**
 * Created by MasterWillis on 11/10/2016.
 */
public class Turtle {

    Grammatik grammatik;
    int growIs = 0;
    char c = 'A';
    private double turnIs;

    public Turtle(Grammatik grammatik, RecursiveLsys lsys) {
        this.grammatik = grammatik;
        drawTurtle();
    }

    public void setGrowIs() {
        growIs = grammatik.getGrow(c);
    }

    public void setTurnIs() {
        turnIs = grammatik.getTurn(c);
    }

    public void drawTurtle() {
        //System.out.println(growIs = grammatik.getGrow('A'));
        //System.out.println(setTurnIs(grammatik.getTurn('A')));
    }
}