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
    RecursiveLsys lsys;
    static JPanel mainPanel = new JPanel();
    ImageIcon cursorPic = new ImageIcon("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\kande.png"); //cursor Path
    String drawString = ""; //NAJA: test
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public StaticView() {

        addPropertyChangeListener(this);
        Brugerinput brugerinput = new Brugerinput(mainPanel, this);
        Texture texture = new Texture();

        Turtle turtle = new Turtle(grammatik, lsys, drawString);
        setTitle("Growing Tree");
        setSize(screenSize); //fullscreen
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println(drawString);


        drawMainPanel();
        cursor();

        //En keyListener der lukker programmet når man trykker på 'escape' på tastaturet:
        addKeyListener(new KeyAdapter() { //close on escape
            public void keyPressed(KeyEvent ke) {  // handler
                if (ke.getKeyCode() == ke.VK_ESCAPE) {
                    System.out.println("escaped");
                    setVisible(false);
                } else {
                    System.out.println("not escaped");
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

            drawString = "F[+F[+F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]][-F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]]][-F[+F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]][-F[+F[+F[+A][-A]][-F[+A][-A]]][-F[+F[+A][-A]][-F[+A][-A]]]]]";
            //drawString = "[-F[-F[+F[+F][-F]][-F[+F][-F]]][+F[+F][-F]]][[+F[-F[A]][+F[A]]]";
            new Turtle(grammatik, lsys, drawString);
            repaint();
       }
       else System.out.println("none");
    }





}




