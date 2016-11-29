package LsysGUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Prototype 2s brugerinput skal kun være et klik fra musen der aktivere lsystemet og tegner det.
 * Der bliver bliver fokuseret mere på et advanceret indput når vi kommer til prototype 3 (sliders, knapper osv)
 */

public class Brugerinput implements MouseListener{




    public Brugerinput(JPanel mainPanel) {
        System.out.println("brugerinput kører");

        mainPanel.addMouseListener(this);

        //mainPanel.getPropertyChangeListeners();




    }

    @Override
    public void mouseClicked(MouseEvent e) {


        int x = e.getX();
        int y = e.getY();

        //x = 275-325
       // y = 550-600

        if ((x > 275 && x < 325) && (y > 550 && y < 600)) {
            System.out.println("start turtle");


        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}