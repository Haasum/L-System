package LsysGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static LsysGUI.GUI.mainPanel;
import static javafx.event.Event.fireEvent;

/**
 * Prototype 2s brugerinput skal kun være et klik fra musen der aktivere lsystemet og tegner det.
 * Der bliver bliver fokuseret mere på et advanceret indput når vi kommer til prototype 3 (sliders, knapper osv)
 */

public class Brugerinput implements MouseListener, ActionListener{

GUI gui;

    public Brugerinput(JPanel mainPanel, GUI gui) {
        System.out.println("brugerinput kører");
        this.gui = gui;

        mainPanel.addMouseListener(this);




    }

    @Override
    public void mouseClicked(MouseEvent e) {


        int x = e.getX();
        int y = e.getY();

        if ((x > 275 && x < 325) && (y > 550 && y < 600)) {
            System.out.println("start turtle");
            gui.firePropertyChange("g",0,1);

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}