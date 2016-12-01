package LsysGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static LsysGUI.Turtle.middleX;
import static LsysGUI.Turtle.screenHeight;

/**
 * Prototype 2s brugerinput skal kun være et klik fra musen der aktivere lsystemet og tegner det.
 * Der bliver bliver fokuseret mere på et advanceret indput når vi kommer til prototype 3 (sliders, knapper osv)
 */

public class Brugerinput implements MouseListener, ActionListener{

StaticView staticView;

    public Brugerinput(JPanel mainPanel, StaticView staticView) {
        System.out.println("brugerinput kører");
        this.staticView = staticView;

        mainPanel.addMouseListener(this);




    }

    @Override
    public void mouseClicked(MouseEvent e) {


        int x = e.getX();
        int y = e.getY();


       // g2d.fillOval(middleX-200,screenHeight-100,400,200);
        /*
        middleX-200 - middleX + 200
        screenHeight-100 - screenHeight +100
        */

        if ((x > middleX-200 && x < middleX+200) && (y > screenHeight-100 && y < screenHeight+100)) {
            System.out.println("start turtle");
            staticView.firePropertyChange("g",0,1);

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