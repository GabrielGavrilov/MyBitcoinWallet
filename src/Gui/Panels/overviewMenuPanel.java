package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import java.awt.*;

public class overviewMenuPanel extends JPanel {

    userAPI user = new userAPI();

    /*
        PUBLIC LABELS
    */

    public overviewMenuPanel() {

        this.setLayout(null);
        this.setBounds(190,0,485,500);
        this.setBackground(new Color(20, 24, 34));

        /*
            LABELS
        */

        JLabel totalWalletBalanceLabel = new JLabel();
        totalWalletBalanceLabel.setText("Total balance");
        totalWalletBalanceLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        totalWalletBalanceLabel.setBounds(75, 25, 485, 35);
        totalWalletBalanceLabel.setForeground(Color.white);

        JLabel walletBitcoinBalace = new JLabel();
        walletBitcoinBalace.setText(user.getUserBtcBalance());
        walletBitcoinBalace.setFont(new Font("ARIAL", Font.BOLD, 23));
        walletBitcoinBalace.setBounds(75, 50, 485, 35);
        walletBitcoinBalace.setForeground(Color.white);

        JLabel walletUsdBalance = new JLabel();
        walletUsdBalance.setText(user.getUserUsdBalance());
        walletUsdBalance.setFont(new Font("ARIAL", Font.BOLD, 23));
        walletUsdBalance.setBounds(300,50,485,35);
        walletUsdBalance.setForeground(Color.white);

        /*
            ADDING
        */

        this.add(totalWalletBalanceLabel);
        this.add(walletBitcoinBalace);
        this.add(walletUsdBalance);

    }

}
