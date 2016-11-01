package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.List;

import static LsysGUI.GUI.mainPanel;


public class Turtle extends JPanel {

    Grammatik grammatik;
    int growIs;
    char c = 'A';
    private double turnIs;
    JPanel testPanel;
    Graphics g;
    int lang;
    int start2;
    int branchHeight;
    int startY = getHeight();
    int startX;
    int rotationen;
    int pushIt;
    AffineTransform saveMatrix;
    AffineTransform newMatrix;
    AffineTransform oldMatrix;
    int pushY;
    boolean pop;
    int testHeight;
    int testY;
    boolean push = false;

    boolean startDraw;
    List<Shape> shapes = new ArrayList<>(); //TEST
    List<Line2D> lines = new ArrayList<>();
    List<Integer> ints = new ArrayList<>();

    String drawThis = "A[+A][-A]"; //test string


    public Turtle(Grammatik grammatik, RecursiveLsys lsys) {
        this.grammatik = grammatik;
        startDraw = false;
        System.out.println(growIs);
        makeTestPanel();
       // drawTurtle();


    }

    private void makeTestPanel() {
        JPanel testPanel = new JPanel() {

            public void paintComponent(Graphics g) {



                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g.create();


                g2d.setColor(Color.BLACK);

                //  g2d.setTransform(newMatrix);


                for (int i = 0; i < drawThis.length(); i++) {
                    char currentCheck = drawThis.charAt(i);

                    //DEN RIGTIGE:
                  /*  if (Character.isLetter(currentCheck)) {
                        branchHeight = 500;
                        System.out.println(growIs);
                    }  //TODO: det skal være med denne det skal kører */

                    switch (currentCheck) {
                        case 'A':
                            growBranch(g2d);
                            break;
                        case '+':
                            rotateRight(g2d);
                            break;
                        case '-':
                            rotateLeft(g2d);
                            break;
                        case '[':
                            push(g2d, g2d.getTransform());
                            break;
                        case ']':
                            pop(g2d);
                            break;
                        default:
                            System.out.println("Char not in alphabet");
                            break;
                    }

                }

            }

            private void push(Graphics g2d, AffineTransform transform) {
                System.out.println("[");
                saveMatrix = transform;

                newMatrix = AffineTransform.getTranslateInstance(0,testHeight+5);
                transform.setTransform(newMatrix);


            }

            private void pop(Graphics g2d) {
                System.out.println("]");
            }



            private void rotateLeft(Graphics g2d) {
                System.out.println("-");
            }

            private void rotateRight(Graphics g2d) {
                System.out.println("+");
            }

            private void growBranch(Graphics g2d) {
                System.out.println("A");
                testHeight += 20;

                g2d.drawLine(300, startY,300,testHeight+2);
                repaint();
            }

        };

        testPanel.setSize(600, 600);
        testPanel.setVisible(true);
        testPanel.setBackground(new Color(99, 125, 150));
        testPanel.setLayout(null);
        mainPanel.add(testPanel);

    }

}


           /*
                SUPER PAINTCOMPONENT - DEN GAMLE - TEST
                super.paintComponent(g);


                Graphics2D g2d = (Graphics2D)g.create();
                g2d.setColor(Color.red);

                for (Line2D line : lines)
                {
                   // g2d.rotate(Math.toRadians(10), startX, startY);
                    //g2d.rotate(Math.toRadians(rotationen));

                    saveMatrix = g2d.getTransform(); //PUSH
                   // oldMatrix = AffineTransform.getTranslateInstance(0,0);

                     //skal rykkes til push metode
                    //pushIt += 60;
                    newMatrix = AffineTransform.getTranslateInstance(0,pushIt);
                    //set rotation
                    g2d.setTransform(newMatrix);

                   // g2d.translate(0,60); //ændrer nulpunkt
                    g2d.setColor(Color.black);
                    g2d.draw( line );

                    // g2d.setTransform(saveMatrix); //POP

                }


                g2d.dispose();

            }

        };

        testPanel.setSize(600, 600);
        testPanel.setVisible(true);
        testPanel.setBackground(new Color(99, 125, 150));
        testPanel.setLayout(null);
        mainPanel.add(testPanel);


    }


/* UDKOMMENTERET FOR TEST PURPOSE

    public void drawTurtle() {

        for (int i = 0; i < drawThis.length(); i++) {
            char currentCheck = drawThis.charAt(i);

            //DEN RIGTIGE:
            if (Character.isLetter(currentCheck)) {
                    branchHeight = 500;
                    System.out.println(growIs);
            }  //TODO: det skal være med denne det skal kører

            switch (currentCheck) {
                case 'A':
                    growBranch();
                    break;
                case '+':
                    rotateRight();
                    break;
                case '-':
                    rotateLeft();
                    break;
                case '[':
                    push();
                    break;
                case ']':
                    pop();
                    break;
                default:
                    System.out.println("Char not in alphabet");
                    break;
            }

        }
    }

    METODER DER STYRER HVAD DER SKER MED TRÆET:

    private void push() {
        pushIt += 60;
        repaint();
       //saveMatrix = new AffineTransform(0,60);
        System.out.println("[");
        //lines.add(new Line2D.Double(0, 0,0, 0));
    }

    private void pop() {
        //pushIt = 0;
        pop = true;
        System.out.println("]");
    }



    private void rotateLeft() {
        System.out.println("-");
    }

    private void rotateRight() {
        System.out.println("+");
    }

    private void growBranch() {
        System.out.println("A");
        branchHeight = 50; //Getbranch height
        startX = 300;

        lines.add(new Line2D.Double(startX, startY, startX, branchHeight));
    }
    UDKOMMENTERING SLUT
    */





 /*   public void setGrowIs() {
        growIs = grammatik.getGrow(c);
    } */
            //TODO: growIs skal hentes fra gramatik klassens alfabet.

