package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Prototype 2s brugerinput skal kun være et klik fra musen der aktivere lsystemet og tegner det.
 * Der bliver bliver fokuseret mere på et advanceret indput når vi kommer til prototype 3 (sliders, knapper osv)
 */

public class Brugerinput implements MouseListener, ActionListener{

    StaticView staticView;
    JPanel mainPanel;
    RecursiveLsys lsys;
    Grammatik grammatik;

    public Brugerinput(JPanel mainPanel, RecursiveLsys lsys) {
        System.out.println("brugerinput kører");
        this.lsys = lsys;

        this.mainPanel = mainPanel;

        mainPanel.addMouseListener(this);

    }



    @Override
    public void mouseClicked(MouseEvent e) {


        int x = e.getX();
        int y = e.getY();

        System.out.println("mouseClicked");

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



