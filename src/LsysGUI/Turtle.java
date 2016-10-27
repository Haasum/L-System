package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
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
    int start2;
    int branchHeight;
    int startY = 600;
    int startX;

    boolean startDraw;
    List<Shape> shapes = new ArrayList<>(); //TEST
    List<Line2D> lines = new ArrayList<>();

    String drawThis = "A[+B][-A]"; //test string


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

                g2d.setColor(Color.red);


                for (Shape shape: shapes)
                {
                    g2d.setColor( Color.RED );
                    //g2d.fill( shape );
                }


                for (Line2D line : lines)
                {
                    g2d.setColor(Color.black);
                    g2d.draw( line );

                }
                g2d.dispose();

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

        for (int i = 0; i < drawThis.length(); i++) {
            char currentCheck = drawThis.charAt(i);

           /* if (Character.isLetter(currentCheck)) {
                    branchHeight = 500;
                    System.out.println(growIs);
            } */

            if (currentCheck == 'A') {
                branchHeight = 500;
                startX = 300;

            }
            if (currentCheck == 'B') {
                branchHeight = 100;
                startX = 100;

            }

            lines.add(new Line2D.Double(startX, startY, startX, branchHeight));




       /* for(int i = 0; i < 10; i++) {


            lang += 5;
            start2 += 10;
            shapes.add( new Ellipse2D.Double(lang, 50, 50, 50) ); //TEST

            lines.add( new Line2D.Double(start2,lang,50,50));

        } */

        }

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