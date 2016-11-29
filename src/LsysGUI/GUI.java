package LsysGUI;

import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * GUI står for at lave vores interface, vinduet som skal tegnes på af turtlen osv.
 *
 */
public class GUI extends JFrame implements PropertyChangeListener {

    Turtle turtle;
    Grammatik grammatik;
    RecursiveLsys lsys;
    static JPanel mainPanel = new JPanel();
    ImageIcon cursorPic = new ImageIcon("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\kande.png"); //cursor Path
    String drawString = "";

    public GUI() {



        Turtle turtle = new Turtle(grammatik, lsys, drawString);
        Brugerinput brugerinput = new Brugerinput(mainPanel, this);


        setTitle("Growing Tree");
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        drawMainPanel();
        cursor();



    }

    public void drawMainPanel() {
        //the mainPanel:
        add(mainPanel);
        mainPanel.setSize(600, 600);
        mainPanel.setVisible(true);
        mainPanel.setBackground(null);
        mainPanel.setLayout(null);
        addPropertyChangeListener(this);
    }

    public void cursor() {
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursorPic.getImage(), new Point(0, 0), "customCursor"));


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        if (name == "g") {
            System.out.println("grow tree");
            drawString = "F[-F[-F[+F[+F][-F]][-F[+F][-F]]][+F[+F][-F]]][[+F[-F[A]][+F[A]]]";

        }
        else System.out.println("none");
    }


}




