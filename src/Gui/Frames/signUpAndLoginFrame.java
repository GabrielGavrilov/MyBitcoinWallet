package Gui.Frames;

import Gui.Panels.loginPanel;
import Gui.Panels.signUpPanel;

import javax.swing.*;

public class signUpAndLoginFrame extends JFrame {

    public signUpAndLoginFrame() throws InterruptedException {

        this.setTitle("Sign Up :: MyBitcoinWallet ");
        this.setSize(400, 290);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        /*
            PANELS
        */

        signUpPanel pSignUp = new signUpPanel();
        loginPanel pLogin = new loginPanel();

        /*
            ADDING
        */

        this.setVisible(true);
        this.add(pSignUp);
        pLogin.setVisible(false);
        this.add(pLogin);

        /*
            PANEL MANAGER
        */

        while(true) {

            Thread.sleep(500);

            if(pSignUp.isVisible() == false) {
                this.setTitle("Login :: MyBitcoinWallet");
                pLogin.setVisible(true);
            }

        }

    }

}
