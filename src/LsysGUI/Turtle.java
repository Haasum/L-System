package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static LsysGUI.StaticView.mainPanel;
import static LsysGUI.StaticView.screenSize;
import static LsysGUI.Texture.backImg;
import static LsysGUI.Texture.leafImg;
import static LsysGUI.Texture.leafImg2;


public class Turtle extends JPanel {

    Grammatik grammatik;
    JPanel testPanel;
    JButton terminalBtn;
    int testHeight;
    int btnPressed;
    ArrayList<AffineTransform> stack = new ArrayList<AffineTransform>();
    ArrayList <AffineTransform> oldTrans = new ArrayList<>();
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

    AffineTransform originalTrans = AffineTransform.getTranslateInstance(middleX,screenHeight-250);

    String drawThis;

    public Turtle(Grammatik grammatik, RecursiveLsys lsys, String draw) {



        System.out.println("start turtle");
        this.grammatik = grammatik;
        drawThis = draw;
        makeTestPanel();


    }

    public void makeTestPanel() {

        testPanel = new JPanel() {

            public void paintComponent(Graphics g) { //TODO: få så meget som muligt ud af paintcomponent metoden


                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                g2d.drawImage(backImg, 0, -75, this); //backgroundIMG

                g2d.setPaint(Texture.soilTex); //sets the soil texture
                makeGroundObject(g2d);

                g2d.setPaint(Texture.barkTex);
                makeLog(g2d);


                //branch test
               // makeBranch(g2d);
               // g2d.fill(branchShape);


                g2d.setTransform(originalTrans);



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
                g2d.rotate(Math.PI/7);
            }

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




            private void savePoint(Graphics2D g2d) {
                test++;

                AffineTransform currentT = g2d.getTransform();//saves the currenttransform to an array of old transforms
                int buttonX = (int) currentT.getTranslateX();
                int buttonY = (int) currentT.getTranslateY();
                int buttonsize = 10;

                terminalBtn = new JButton(String.valueOf(test));
                testPanel.add(terminalBtn);
                terminalBtn.setBounds(buttonX-buttonsize/2,buttonY-buttonsize,buttonsize,buttonsize);
                terminalBtn.setBackground(greenCol);
               //
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

                        //TODO: dette er midlertidigt. Når button er pressed skal Lsys udvides (med nodes). og så tegner paincomponent igen, men de nye udvidelser
                    }

                });

                oldTrans.add(currentT);
                repaint(); //repaint skal ligge her, for at den tegner når turtle kaldes 2. gang (ved tryk på jord

            }

        };

        testPanel.setSize(screenSize);
        testPanel.setVisible(true);
        testPanel.setBackground(new Color(99, 125, 150));
        testPanel.setLayout(null);
        mainPanel.add(testPanel);

        testHeight = 50;


    }

    private void makeLog(Graphics2D g2d) { //skal tilsluttes translate. dvs punkterne skal opdateres og metoden skal kaldes efter translate
//TODO: skal gøres lækker
        final double points[][]= {

                { middleX+2, screenHeight-250 }, { middleX-2, screenHeight-250 }, //top
               // {200,120},{210,122}, {209,126}, {200,128}, //en knop på træet
               // {200,215},{208,217}, {211,230}, {201,234},
               // {200,240},{208,242}, {211,252}, {201,253}, //en knop på træet

                { middleX-10, screenHeight-100}, { middleX+10, screenHeight-100} //bund
               // ,{ 191, 100 } //tilbage til toppen
        };

        logShape.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++)
            logShape.lineTo(points[k][0], points[k][1]);

        logShape.closePath();
        g2d.fill(logShape);

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
    }




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
