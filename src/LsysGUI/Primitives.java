//TODO: DENNE KLASSE HAR INGEN FUNKTION PT! skal dog bruges i forbindelse med turtle senere


package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by naja on 04-11-2016.
 */
public class Primitives extends Turtle {

    public Primitives(Grammatik grammatik, RecursiveLsys lsys) {
        super(grammatik, lsys);
    }

    public void push(Graphics g2d, AffineTransform transform) {
        System.out.println("[");
        saveMatrix = transform;
        System.out.println("savematrix is " + saveMatrix);

        newMatrix = AffineTransform.getTranslateInstance(0,-50);
        // newMatrix
        // transform.setTransform(newMatrix);
        //
        //
        // Event.fireEvent(changeTransform, isChanged);

        // System.out.println("newmatrix is" + newMatrix);



    }

    public void pop(Graphics g2d) {
        System.out.println("]");
    }

    public void rotateLeft(Graphics g2d) {
        System.out.println("-");
    }

    public void rotateRight(Graphics g2d) {
        System.out.println("+");
    }

    public void growBranch(Graphics g2d) {
        System.out.println("A");
        testHeight = 20;
        startY = this.getY();
        g2d.drawLine(300,0,300,testHeight+5);
        repaint();
    }
}
