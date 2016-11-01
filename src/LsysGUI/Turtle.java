package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;
import com.sun.javafx.geom.transform.Translate2D;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

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
        drawTurtle();




    }

    private void makeTestPanel() {
        JPanel testPanel = new JPanel(){

            public void paintComponent(Graphics g){
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D)g.create();

                g2d.setColor(Color.red);



                for (Shape shape: shapes)
                {
                    g2d.setColor( Color.RED );
                    //g2d.fill( shape );
                }

                for (Integer integer : ints) {
                   // g2d.rotate(Math.toRadians(ints.get(integer)));

                }


                for (Line2D line : lines)

                {
                   // g2d.rotate(Math.toRadians(10), startX, startY);
                    //g2d.rotate(Math.toRadians(rotationen));
                    AffineTransform saveMatrix;

                    saveMatrix = g2d.getTransform();
                    //g2d.getTransform();
                    g2d.translate(0,60);
                    g2d.setColor(Color.black);
                    g2d.draw( line );
                    g2d.setTransform(saveMatrix);

                    //rotationen = 0;

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

        for (int i = 0; i < drawThis.length(); i++) {
            char currentCheck = drawThis.charAt(i);

            //DEN RIGTIGE:
           /* if (Character.isLetter(currentCheck)) {
                    branchHeight = 500;
                    System.out.println(growIs);
            } */ //TODO: det skal være med denne det skal kører

            switch (currentCheck) {
                case 'A':

                    System.out.println("A");
                    branchHeight = 50; //Getbranch height
                    startX = 300;

                    lines.add(new Line2D.Double(startX, startY, startX, branchHeight));

                    break;
                case '+':
                    System.out.println("+");
                    //rotationen = 0;
                   // ints.add(new Integer(10));
                    break;

                case '-':
                    //rotationen = -10;
                    System.out.println("-");
                   // ints.add(new Integer(-10));
                    break;
                case '[':
                    //translates.add(new Translate(0.0,0.0));
                    System.out.println("[");
                    //startY += branchHeight + 10;
                    break;
                case ']':
                    //startY -= branchHeight - 10;
                    System.out.println("]");
                    break;
                default:
                    System.out.println("Char not in alphabet");
                    break;
            }



            //List<Translate2D> translates = new ArrayList<>();

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

 /*   public void setGrowIs() {
        growIs = grammatik.getGrow(c);
    } */
 //TODO: growIs skal hentes fra gramatik klassens alfabet.

    public void setTurnIs() {
        turnIs = grammatik.getTurn(c);
    }
}