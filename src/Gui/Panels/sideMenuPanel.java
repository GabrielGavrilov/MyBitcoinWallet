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

        this.setBackground(new Color(9, 12, 20));
        this.setBounds(0,0,190, 500);
        this.setLayout(null);

        /*
            LABELS
        */

        JLabel totalBalanceLabel = new JLabel();
        totalBalanceLabel.setText("TOTAL BALANCE:");
        totalBalanceLabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        totalBalanceLabel.setForeground(new Color(126, 133, 143));
        totalBalanceLabel.setBounds(10,20,150,20);

        btcWalletBalance.setText("0.00000000"); // CHANGE THIS LATER
        btcWalletBalance.setFont(new Font("ARIAL", Font.BOLD, 16));
        btcWalletBalance.setForeground(Color.white);
        btcWalletBalance.setBounds(10,55,150,20);

        usdWalletBalance.setText("$0.00"); // CHANGE THIS LATER
        usdWalletBalance.setFont(new Font("ARIAL", Font.BOLD, 11));
        usdWalletBalance.setForeground(new Color(126, 133, 143));
        usdWalletBalance.setBounds(10, 75, 150, 20);

        JLabel btcLabel = new JLabel();
        btcLabel.setText("BTC");
        btcLabel.setFont(new Font("ARIAL", Font.PLAIN, 9));
        btcLabel.setBounds(btcWalletBalance.getX() + 89, 53, 150, 20);
        btcLabel.setForeground(new Color(126, 133, 143));

        JLabel usdLabel= new JLabel();
        usdLabel.setText("USD");
        usdLabel.setFont(new Font("ARIAL", Font.PLAIN, 9));
        usdLabel.setBounds(usdWalletBalance.getX() + 30, 75, 150, 20);
        usdLabel.setForeground(new Color(126, 133, 143));

        /*
            ADDING
        */

        this.add(totalBalanceLabel);
        this.add(btcWalletBalance);
        this.add(btcLabel);
        this.add(usdWalletBalance);
        this.add(usdLabel);

    }

}
