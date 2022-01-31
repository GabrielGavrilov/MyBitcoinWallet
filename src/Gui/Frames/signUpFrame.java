package Gui.Frames;

import Gui.Panels.signUpPanel;

import javax.swing.*;

public class signUpFrame extends JFrame {

    public signUpFrame() {

        this.setTitle("Sign Up :: MyBitcoinWallet ");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        /*
            PANELS
        */

        signUpPanel pSignUp = new signUpPanel();

        /*
            ADDING
        */

        this.setVisible(true);
        this.add(pSignUp);

    }

}
