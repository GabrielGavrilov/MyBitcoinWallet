package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import java.awt.*;

public class overviewMenuPanel extends JPanel {

    userAPI userAPI = new userAPI();

    /*
        PUBLIC BUTTONS
    */

    public JButton sendButton = new JButton("Send Bitcoin");
    public JButton receiveButton = new JButton("Receive Bitcoin");
    public JButton buyButton = new JButton("Buy Bitcoin");

    public overviewMenuPanel() {

        this.setLayout(null);
        this.setBounds(190,0,485,500);
        this.setBackground(new Color(20, 24, 34));

        /*
            PANELS
        */

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(35, 39, 51));
        bottomPanel.setBounds(0, 415, 485, 75);
        bottomPanel.setLayout(null);

        /*
            BUTTONS
        */

        sendButton.setFont(new Font("ARIAL", Font.BOLD, 14));
        sendButton.setBackground(new Color(247, 147, 26));
        sendButton.setForeground(Color.white);
        sendButton.setFocusable(false);
        sendButton.setBorder(null);
        sendButton.setBounds(100, 255, 135, 33);

        receiveButton.setFont(new Font("ARIAL", Font.BOLD, 14));
        receiveButton.setBackground(new Color(247, 147, 26));
        receiveButton.setForeground(Color.white);
        receiveButton.setFocusable(false);
        receiveButton.setBorder(null);
        receiveButton.setBounds(245, 255, 135, 33);

        buyButton.setFont(new Font("ARIAL", Font.BOLD, 14));
        buyButton.setBackground(new Color(247, 147, 26));
        buyButton.setForeground(Color.white);
        buyButton.setFocusable(false);
        buyButton.setBorder(null);
        buyButton.setBounds(330, 12, 135, 33);

        /*
            LABELS
        */

        JLabel overviewLabel = new JLabel();
        overviewLabel.setText("Overview");
        overviewLabel.setFont(new Font("ARIAL", Font.PLAIN, 27));
        overviewLabel.setForeground(Color.white);
        overviewLabel.setBounds(25,25,400,30);

        JLabel walletOverviewLabel = new JLabel();
        walletOverviewLabel.setText("Your bitcoin wallet overview.");
        walletOverviewLabel.setFont(new Font("ARIAL", Font.BOLD, 13));
        walletOverviewLabel.setForeground(Color.white);
        walletOverviewLabel.setBounds(25,55,400,30);

        JLabel userWalletBalance = new JLabel();
        userWalletBalance.setText(userAPI.getUserBtcBalance() + " BTC");
        userWalletBalance.setFont(new Font("ARIAL", Font.PLAIN, 35));
        userWalletBalance.setForeground(Color.white);
        userWalletBalance.setBounds(110, 195, 400, 30);

        /*
            ADDING
        */

        this.add(overviewLabel);
        this.add(walletOverviewLabel);
        this.add(userWalletBalance);
        this.add(sendButton);
        this.add(receiveButton);
        this.add(bottomPanel);
        bottomPanel.add(buyButton);

    }

}
