package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * StaticView står for at lave vores interface, vinduet som skal tegnes på af turtlen osv.
 *
 */
public class StaticView extends JFrame implements PropertyChangeListener {

    Turtle turtle;
    Grammatik grammatik;
    public static JPanel mainPanel = new JPanel();
    ImageIcon cursorPic = new ImageIcon("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\kande.png"); //cursor Path
    String drawString = ""; //NAJA: test
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    RecursiveLsys lsys;
    String test2 = "";
    int i = 3;


    public StaticView(RecursiveLsys lsys) {
this.lsys = lsys;


        //Texture texture = new Texture(); //TODO: texture skal ikke loades lige nu


        setTitle("Growing Tree");
        setSize(screenSize); //fullscreen
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println(drawString);
        addPropertyChangeListener(this);


        drawMainPanel();


        //En keyListener der lukker programmet når man trykker på 'escape' på tastaturet:
        addKeyListener(new KeyAdapter() { //close on escape
            public void keyPressed(KeyEvent ke) {  // handler
                if (ke.getKeyCode() == ke.VK_ESCAPE) {
                    System.out.println("escaped");
                    setVisible(false);
                } else if (ke.getKeyCode() == ke.VK_UP) {
                    i++;

                    System.out.println("up");
                    test2 = lsys.expand("K",i);
                    lsys.setTree(test2);
                }
             else if (ke.getKeyCode() == ke.VK_DOWN) {
                i--;
                System.out.println("up");
                test2 = lsys.expand("K",i);
                lsys.setTree(test2);
            }
                else {
                    System.out.println("wrong key");
                }
            }
        });

    }


    public void drawMainPanel() {
        //the mainPanel:
        add(mainPanel);
        mainPanel.setSize(screenSize); //fullscreen);
        mainPanel.setVisible(true);
        mainPanel.setBackground(null);
        mainPanel.setLayout(null);

    }

    public void cursor() {
      setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursorPic.getImage(), new Point(0, 0), "customCursor"));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        if (name == "g") {
            System.out.println("grow tree");
           //drawString = "[-F[-F[+F[+F][-F]][-F[+F][-F]]][+F[+F][-F]]][[+F[-F[A]][+F[A]]]";
           // new Turtle(grammatik, lsys, drawString);
            repaint();
       }
       else System.out.println("none");
    }





}




