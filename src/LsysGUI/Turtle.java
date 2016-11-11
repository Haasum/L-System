package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;
import javafx.scene.shape.Line;
import javafx.scene.transform.Affine;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static LsysGUI.GUI.mainPanel;


public class Turtle extends JPanel {

    Grammatik grammatik;
    JPanel testPanel;
    int testHeight;
    int height;
    ArrayList<AffineTransform> stack = new ArrayList<AffineTransform>();

    boolean startDraw;
    String drawThis = "A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]"; //test string


    public Turtle(Grammatik grammatik, RecursiveLsys lsys) {
        this.grammatik = grammatik;
        makeTestPanel();


    }

    private void makeTestPanel() {
        testPanel = new JPanel() {

            public void paintComponent(Graphics g) { //TODO: få så meget som muligt ud af paintcomponent metoden


                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.BLACK);

                g2d.translate(300,0);
                for (int i = 0; i < drawThis.length(); i++) {
                    char currentCheck = drawThis.charAt(i);


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
                            push(g2d);
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

            private void push(Graphics2D g2d) {
                stack.add(g2d.getTransform());

            }

            private void pop(Graphics2D g2d) {
                AffineTransform t = stack.get(stack.size()-1);
                g2d.setTransform(t);
                stack.remove(stack.size()-1);
            }

            private void rotateLeft(Graphics2D g2d) {
                g2d.rotate(Math.PI/6);
            }


            private void rotateRight(Graphics2D g2d) {
                g2d.rotate(-Math.PI/6);
            }

            private void growBranch(Graphics2D g2d) {
                testHeight = 25;
                g2d.drawLine(0,0,0, testHeight);
                g2d.translate(0, testHeight);

                AffineTransform currentT = g2d.getTransform();
                //currentT.getTranslateX(); //TODO: Naja lav arraylist af points og current transform

                System.out.println("current transform X " + currentT.getTranslateX() + "Y is " + currentT.getTranslateY()); //get window location
            }

        };

        testPanel.setSize(600, 600);
        testPanel.setVisible(true);
        testPanel.setBackground(new Color(99, 125, 150));
        testPanel.setLayout(null);
        mainPanel.add(testPanel);

        testHeight = 50;


    }
}
