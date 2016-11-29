package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static LsysGUI.GUI.mainPanel;


public class Turtle extends JPanel {

    Grammatik grammatik;
    JPanel testPanel;
    int testHeight;
    int i = 0;
    int btnPressed;
    ArrayList<AffineTransform> stack = new ArrayList<AffineTransform>();
    ArrayList <AffineTransform> oldTrans = new ArrayList<>();
    ArrayList<JButton> buttonlist= new ArrayList<>();
    int test = 0;
    Map<Integer,AffineTransform> terminalProp = new HashMap<Integer,AffineTransform>();
    boolean btnBo1 = false;
    boolean btnBo2 = false;

    String drawThis;
    //String drawThis = "F[-F[-F[+F[+F][-F]][-F[+F][-F]]][+F[+F][-F]]][[+F[-F[A]][+F[A]]]";

    public Turtle (Grammatik grammatik, RecursiveLsys lsys, String draw) {
        this.grammatik = grammatik;
        makeTestPanel();
        drawThis = draw;


    }

    private void makeTestPanel() {
        testPanel = new JPanel() {

            public void paintComponent(Graphics g) { //TODO: få så meget som muligt ud af paintcomponent metoden


                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(80,49,9));
                g2d.fillOval(250,550,100,100);

                g2d.translate(300, 550);
                AffineTransform originalTrans = g2d.getTransform();


                if (btnBo1 == true) {

                    g2d.setTransform(terminalProp.get(1));

                    rotateRight(g2d);
                    growBranch(g2d, '*');
                    rotateLeft(g2d);
                    growBranch(g2d, '*');
                }

                if (btnBo2 == true) {

                    g2d.setTransform(terminalProp.get(2));
                    rotateRight(g2d);
                    growBranch(g2d, '*');
                    rotateLeft(g2d);
                    growBranch(g2d, '*');
                }

                g2d.setTransform(originalTrans);

                for (int i = 0; i < drawThis.length(); i++) {
                    char currentCheck = drawThis.charAt(i);

                    switch (currentCheck) {
                        case 'A':
                            savePoint(g2d);
                            break;
                        case 'F':
                            growBranch(g2d, drawThis.charAt(i + 1));
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
                testHeight = -50;
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
                terminalBtn.setBackground(new Color(34,139,34));
                terminalBtn.addActionListener(new ActionListener() {
                    @Override
                        public void actionPerformed(ActionEvent e) { //TODO: skal i brugerindput klasse
                        btnPressed = Integer.parseInt(e.getActionCommand());
                        terminalProp.put(btnPressed, currentT);
                        if (btnPressed == 1) {
                            btnBo1 = true; //TODO: btnpressed skal hente nodes, og så tegnes der en anden streng (med udvidelser)
                            //skal egentlig bare erstatte de steder der er et A med x [+F][-F]
                        }
                        if (btnPressed == 2) {
                            btnBo2 = true; //TODO: btnpressed skal hente nodes, og så tegnes der en anden streng (med udvidelser)
                        }
                        repaint();

                        //TODO: dette er midlertidigt. Når button er pressed skal Lsys udvides (med nodes). og så tegner paincomponent igen, men de nye udvidelser
                    }

                });

                oldTrans.add(currentT);

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
