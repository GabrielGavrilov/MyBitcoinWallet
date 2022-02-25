package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import java.awt.*;

public class overviewMenuPanel extends JPanel {

    userAPI userAPI = new userAPI();

    /*
        PUBLIC BUTTONS
    */

    JButton sendButton = new JButton("Send Bitcoin");
    JButton receiveButton = new JButton("Receive Bitcoin");

    public overviewMenuPanel() {

        this.setLayout(null);
        this.setBounds(190,0,485,500);
        this.setBackground(new Color(20, 24, 34));

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

        /*
            ADDING
        */

        this.add(overviewLabel);
        this.add(walletOverviewLabel);
        this.add(sendButton);
        this.add(receiveButton);

    }

}
