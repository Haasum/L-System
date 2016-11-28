package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;
import javafx.scene.shape.Line;
import javafx.scene.transform.Affine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static LsysGUI.GUI.mainPanel;


public class Turtle extends JPanel {

    Grammatik grammatik;
    JPanel testPanel;
    int testHeight;
    int i = 0;
    ArrayList<AffineTransform> stack = new ArrayList<AffineTransform>();
    ArrayList <AffineTransform> oldTrans = new ArrayList<>();
    ArrayList<JButton> buttonlist= new ArrayList<>();
    int test = 0;
    JButton buttons[];
    Map<Integer,AffineTransform> terminalProp = new HashMap<Integer,AffineTransform>();


    String drawThis = "F[-F[-F[+F][-F]][+F[+F][-F]]][[+F[-F[A]][+F[A]]]";
    //String drawThis = "A[+A[+A[+A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]][-A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]]][-A[+A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]][-A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]]]][-A[+A[+A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]][-A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]]][-A[+A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]][-A[+A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]][-A[+A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]][-A[+A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]][-A[+A[+A[+A][-A]][-A[+A][-A]]][-A[+A[+A][-A]][-A[+A][-A]]]]]]]]]"; //test string


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
                            savePoint(g2d);
                            break;
                        case 'F':
                            growBranch(g2d, drawThis.charAt(i+1));
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
                g2d.rotate(Math.PI/10);
            }


            private void rotateRight(Graphics2D g2d) { g2d.rotate(-Math.PI/10); }

            private void growBranch(Graphics2D g2d, char a) {
                testHeight = 35;
                g2d.drawLine(0,0,0, testHeight);

                    if (a == ']' || a == '[')
                    {
                       g2d.translate(0,testHeight);
                    }
                }




            private void savePoint(Graphics2D g2d) {
                test++;

                AffineTransform currentT = g2d.getTransform();//saves the currenttransform to an array of old transforms
                int buttonX = (int) currentT.getTranslateX();
                int buttonY = (int) currentT.getTranslateY();
                int buttonsize = 10;

                JButton terminalBtn = new JButton(String.valueOf(test));
                testPanel.add(terminalBtn);
                terminalBtn.setBounds(buttonX-buttonsize/2,buttonY,buttonsize,buttonsize);
                terminalBtn.setBackground(Color.black);
                terminalBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int btnpressed = Integer.parseInt(e.getActionCommand());
                        terminalProp.put(btnpressed,currentT);
                        System.out.println(terminalProp);
                        expandTree(terminalProp.get(btnpressed), g2d);
                    }

                });

                oldTrans.add(currentT);

            }

            public void expandTree(AffineTransform transform, Graphics2D g2d) {
                g2d.setTransform(transform);
                g2d.drawLine(0,0,0, testHeight);
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
