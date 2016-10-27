package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
import java.util.List;

import static LsysGUI.GUI.mainPanel;


public class Turtle extends JPanel {

    Grammatik grammatik;
    int growIs = 0;
    char c = 'A';
    private double turnIs;
    JPanel testPanel;
    Graphics g;
    int lang;
    boolean startDraw;
    List<Shape> shapes = new ArrayList<>(); //TEST


    public Turtle(Grammatik grammatik, RecursiveLsys lsys) {
        this.grammatik = grammatik;
        startDraw = false;

        makeTestPanel();
        drawTurtle();




    }

    private void makeTestPanel() {
        JPanel testPanel = new JPanel(){

            public void paintComponent(Graphics g){
                super.paintComponent(g);
                System.out.println(lang);

                Graphics2D g2d = (Graphics2D)g.create();

                for (Shape shape: shapes)
                {
                    g2d.setColor( Color.RED );
                    g2d.fill( shape );
                }
                g2d.dispose();


                if (startDraw = true) {
                    g.setColor(Color.black);

                    //g.drawLine(getWidth() / 2, getHeight(), getWidth() / 2, 55);
                    //g.fillOval(10,10, 15, 15);
                }
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

        for(int i = 0; i < 10; i++) {
            System.out.println("Loopet kører");
            lang += 50;
            shapes.add( new Ellipse2D.Double(lang, 50, 50, 50) ); //TEST

        }

          //  super.paintComponent(g);
          //  g.drawLine(getWidth() / 2, getHeight(), getWidth() / 2, 10);
          //  paint();

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