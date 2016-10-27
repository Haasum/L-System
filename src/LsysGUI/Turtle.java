package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;

import static LsysGUI.GUI.mainPanel;


public class Turtle extends JPanel {

    Grammatik grammatik;
    int growIs = 0;
    char c = 'A';
    private double turnIs;
    JPanel testPanel;

    public Turtle(Grammatik grammatik, RecursiveLsys lsys) {
        this.grammatik = grammatik;

        makeTestPanel();
        drawTurtle();
        repaint();
    }

    private void makeTestPanel() {
        JPanel testPanel = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);

                g.setColor(Color.black);
                g.drawOval(10,10,15,15);
                g.fillOval(10,10, 15, 15);
            }
        };
        //JPanel testPanel = new JPanel();
        testPanel.setSize(600, 600);
        testPanel.setVisible(true);
        testPanel.setBackground(new Color(99, 125, 150));
        testPanel.setLayout(null);
        mainPanel.add(testPanel);


    }


    public void drawTurtle() {
        System.out.println("turtle draw");


    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10 + 10, 20 + 20);
    }


    public void setGrowIs() {
        growIs = grammatik.getGrow(c);
    }

    public void setTurnIs() {
        turnIs = grammatik.getTurn(c);
    }
}