package LsysGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by naja on 01-12-2016.
 */
public class ButtonNodeActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("is clicked");
    }
}


 /* terminalBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { //TODO: skal i brugerindput klasse
                        btnPressed = Integer.parseInt(e.getActionCommand());
                        terminalProp.put(btnPressed, currentT);
                        if (btnPressed == 1) {
                            btnBo1 = true; //TODO: btnpressed skal hente nodes, og så tegnes der en anden streng (med udvidelser)
                        } */
