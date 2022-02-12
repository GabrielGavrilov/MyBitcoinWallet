package Gui.Frames;

import Gui.Panels.sideMenuPanel;

import javax.swing.*;
import java.awt.*;

public class walletFrame extends JFrame {

    /*
        PANELS
    */

    sideMenuPanel sideMenu = new sideMenuPanel();

    public walletFrame() {

        this.setLayout(null);
        this.setSize(675, 500);
        this.getContentPane().setBackground(new Color(20, 24, 34));
        this.setTitle("Wallet :: MyBitcoinWallet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        /*
            ADDING
        */

        this.add(sideMenu);

        this.setVisible(true);

    }

}
