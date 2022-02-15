package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class receiveMenuPanel extends JPanel {

    static userAPI user = new userAPI();

    public receiveMenuPanel() {

        this.setBackground(new Color(20, 24, 34));
        this.setLayout(null);
        this.setBounds(190,0,485,500);

        /*
            LABELS
        */

        JLabel receiveLabel = new JLabel();
        receiveLabel.setText("Receive");
        receiveLabel.setFont(new Font("ARIAL", Font.PLAIN, 27));
        receiveLabel.setForeground(Color.white);
        receiveLabel.setBounds(25, 25, 400, 30);

        JLabel bitcoinOnlyLabel = new JLabel();
        bitcoinOnlyLabel.setText("Receive only Bitcoin (BTC) to this address below.");
        bitcoinOnlyLabel.setFont(new Font("ARIAL", Font.BOLD, 13));
        bitcoinOnlyLabel.setForeground(Color.white);
        bitcoinOnlyLabel.setBounds(25,55,400,30);

        JLabel walletAddressLabel = new JLabel();
        walletAddressLabel.setText("WALLET ADDRESS");
        walletAddressLabel.setFont(new Font("ARIAL", Font.PLAIN, 12));
        walletAddressLabel.setForeground(new Color(126, 133, 143));
        walletAddressLabel.setBounds(25, 100, 400, 30);

        /*
            TEXT FIELDS
        */

        JTextField walletAddress = new JTextField();
        walletAddress.setText(" " + user.getUserPublicWallet());
        walletAddress.setBounds(25, 128, 423, 30);
        walletAddress.setFont(new Font("ARIAL", Font.PLAIN, 17));
        walletAddress.setBackground(new Color(9,12,20));
        walletAddress.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        walletAddress.setForeground(Color.white);
        walletAddress.setEditable(false);

        /*
            ADDING
        */

        this.add(receiveLabel);
        this.add(bitcoinOnlyLabel);
        this.add(walletAddressLabel);
        this.add(walletAddress);

    }

}
