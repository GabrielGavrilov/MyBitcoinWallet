package Gui.Panels;

import javax.swing.*;
import java.awt.*;

public class sideMenuPanel extends JPanel {

    /*
        MENU BITCOIN WALLET VARIABLES
    */

    public JLabel btcWalletBalance = new JLabel();
    public JLabel usdWalletBalance = new JLabel();

    public sideMenuPanel() {

        this.setBackground(Color.pink);
        this.setBounds(0,0,190, 500);
        this.setLayout(null);

        /*
            LABELS
        */

        JLabel totalBalanceLabel = new JLabel();
        totalBalanceLabel.setText("TOTAL BALANCE:");
        totalBalanceLabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        totalBalanceLabel.setBounds(10,20,150,20);

        btcWalletBalance.setText("0.00000000");
        btcWalletBalance.setFont(new Font("ARIAL", Font.BOLD, 16));
        btcWalletBalance.setBounds(10,55,150,20);

        JLabel btcLabel = new JLabel();
        btcLabel.setText("BTC");
        btcLabel.setFont(new Font("ARIAL", Font.PLAIN, 9));
        btcLabel.setBounds(97, 53, 150, 20);

        /*
            ADDING
        */

        this.add(totalBalanceLabel);
        this.add(btcWalletBalance);
        this.add(btcLabel);

    }

}
