package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static LsysGUI.StaticView.mainPanel;
import static LsysGUI.StaticView.screenSize;
import static LsysGUI.Texture.*;


public class Turtle extends JPanel {

    Grammatik grammatik;
    JPanel testPanel;
    JButton terminalBtn;
    int testHeight;
    int btnPressed;
    ArrayList<AffineTransform> stack = new ArrayList<AffineTransform>();
    int test = 0;
    Map<Integer,AffineTransform> terminalProp = new HashMap<Integer,AffineTransform>();
    boolean btnBo1 = false;
    boolean btnBo2 = false;
    static int screenWidth = (int) screenSize.getWidth();
    static int middleX = screenWidth/2;
    static int screenHeight = (int) screenSize.getHeight();
    GeneralPath branchShape = new GeneralPath();
    GeneralPath logShape = new GeneralPath();
    Color greenCol = new Color(34,139,34);
    int counter;
    int test2;

    ButtonNodeActionListener buttonListener;

    AffineTransform originalTrans = AffineTransform.getTranslateInstance(middleX,screenHeight-60);

    String drawThis;

    public Turtle(Grammatik grammatik, RecursiveLsys lsys, String draw) {

        this.grammatik = grammatik;
        drawThis = "K[+F[-A][+A]][-F[+A][-A]]";
        drawThis = "K[+F[+F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]][-F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]]][-F[+F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]][-F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]]]";
        makeTestPanel();

    }

    public void makeTestPanel() {

        testPanel = new JPanel() {

            public void paintComponent(Graphics g) { //TODO: få så meget som muligt ud af paintcomponent metoden

                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                makeBackground(g2d);

                if (btnBo1 == true) {
                    g2d.setTransform(terminalProp.get(1));

                    rotateRight(g2d);
                    growBranch(g2d, '*');
                    rotateLeft(g2d);
                    growBranch(g2d, '*');
                }

                g2d.setTransform(originalTrans);


                for (int i = 0; i < drawThis.length(); i++) {
                    char currentCheck = drawThis.charAt(i);

                    switch (currentCheck) { //TODO: skal ikke være switch case. den skal gemmenløbe regelsæt istedet for stringinputtet
                        case 'A':
                           interpretTerminal(g2d);
                            break;
                        case 'F':
                            growBranch(g2d, drawThis.charAt(i + 1));
                            break;
                        case 'K':
                            makeLog(g2d);
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
                repaint();
            }







        };

        testPanel.setSize(screenSize);
        testPanel.setVisible(true);
        testPanel.setBackground(new Color(99, 125, 150));
        testPanel.setLayout(null);
        mainPanel.add(testPanel);

        testHeight = 50;


    }

    private void interpretTerminal(Graphics2D g2d) { //TODO: lav button betode, så A både kalder en savepoint og en knap metode
        AffineTransform currentT = g2d.getTransform();


        ButtonNode buttonNode = new ButtonNode(currentT);

        testPanel.add(buttonNode.terminalBtn);
        buttonListener = new ButtonNodeActionListener();

    }

    private void makeBackground(Graphics2D g2d) {

        g2d.drawImage(backImg, 0, -75, this); //backgroundIMG

        g2d.setPaint(Texture.soilTex); //sets the soil texture
        makeGroundObject(g2d);
    }

    private void makeLog(Graphics2D g2d) { //skal tilsluttes translate. dvs punkterne skal opdateres og metoden skal kaldes efter translate
//TODO: skal gøres lækker
        g2d.setPaint(Texture.barkTex);
        final double points[][]= {

                { -2, -200}, {2, -200}, //bund
                { 6 ,-20}, { -6,-20 } //bund
        };

        logShape.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            logShape.lineTo(points[k][0], points[k][1]);

        logShape.closePath();
        g2d.fill(logShape);

        g2d.translate(0,-200);

    }


    private void push(Graphics2D g2d) {
        stack.add(g2d.getTransform());

    }

    private void pop(Graphics2D g2d) {
        AffineTransform t = stack.get(stack.size()-1);
        g2d.setTransform(t);
        stack.remove(stack.size()-1);
    }

    private void rotateLeft(Graphics2D g2d) { g2d.rotate(Math.PI/7); }

    private void rotateRight(Graphics2D g2d) { g2d.rotate(-Math.PI/7); }

    private void growBranch(Graphics2D g2d, char a) {
        testHeight = -50;
        counter++;


        g2d.setStroke(new BasicStroke(4.0f));
        g2d.drawLine(0,0,0, testHeight);
        //  drawLeafs(g2d); blade TEST


        if (a == ']' || a == '[')
        {
            g2d.translate(0,testHeight);
        }


    }






    private void drawLeafs(Graphics2D g2d) {


        g2d.drawImage(leafImg, -25,-10,this);
        g2d.drawImage(leafImg, -21,-10,this);
        g2d.drawImage(leafImg, -25,-32,this);
        g2d.drawImage(leafImg, -15,-32,this);
        g2d.drawImage(leafImg, -25,-40,this);
        g2d.drawImage(leafImg, -15,-40,this);
        g2d.drawImage(leafImg, -25,-46,this);
        g2d.drawImage(leafImg, -15,-60,this);
        g2d.drawImage(leafImg, -25,-55,this);
        g2d.drawImage(leafImg, -15,-55,this);

        g2d.drawImage(leafImg2, -5,-7,this);
        g2d.drawImage(leafImg2, 0,-18,this);
        g2d.drawImage(leafImg2, -7,-35,this);
        g2d.drawImage(leafImg2, -2,-44,this);
        g2d.drawImage(leafImg2, 0,-53,this);

         //muligt animationsloop:
        for (int i = 0; i < 10; i++) {



            g2d.drawImage(leafImg2, 0,test,this);
            test2 = test2 +10;
        }



        g2d.setPaint(Texture.barkTex);
    }

    private void makeGroundObject(Graphics2D g2d) {
       g2d.fillOval(middleX-200,screenHeight-120,400,200);
    } //TODO: skal være i static og blive markeret når musen er i nærheden








    //mulig branch shape: er ikke lavet
    private void makeBranch(Graphics2D g2d) {


        final double points[][]= {

                { 150, 100 }, { 200, 100 },
                {200,120},{210,135},
                {200,140},
                {200,160},
                {200,180},
                {200,200},
                {200,220},
                {200,240},
                {200,260},
                {200,280},
                {200,300},
                {200,320},
                {200,340},
                {200,360},
                {200,380},
                {200,400},


                { 200, 450}, { 150, 450 }
                ,{ 150, 100 }


              //  { 0, 85 }, { 75, 78 }, { 100, 10 }, { 125, 75 },
              //  { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 },
              //  { 40, 190 }, { 50, 125 }, { 0, 85 }
        };

       branchShape.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++)
          branchShape.lineTo(points[k][0], points[k][1]);

        branchShape.closePath();
        g2d.fill(branchShape);

    }


}
