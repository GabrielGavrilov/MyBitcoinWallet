package Gui.Frames;

import Gui.Panels.signUpPanel;

import javax.swing.*;

public class signUpAndLoginFrame extends JFrame {

    public signUpAndLoginFrame() {

        this.setTitle("Sign Up :: MyBitcoinWallet ");
        this.setSize(400, 290);
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
