package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class settingsMenuPanel extends JPanel {

    userAPI userAPI = new userAPI();

    /*
        PUBLIC BUTTONS
    */

    public JButton updateBalanceButton = new JButton("Update Balance");
    public JButton deleteButton = new JButton("Delete Account");

    public settingsMenuPanel() {

        this.setBackground(new Color(20, 24, 34));
        this.setLayout(null);
        this.setBounds(190,0,485,500);

        /*
            PANELS
        */

        JPanel settingsBottomPanel = new JPanel();
        settingsBottomPanel.setBackground(new Color(35, 39, 51));
        settingsBottomPanel.setBounds(0,415, 485, 75);
        settingsBottomPanel.setLayout(null);

        /*
            LABELS
        */

        JLabel settingsLabel = new JLabel();
        settingsLabel.setText("Settings");
        settingsLabel.setFont(new Font("ARIAL", Font.PLAIN, 27));
        settingsLabel.setForeground(Color.white);
        settingsLabel.setBounds(25,25,400,30);

        JLabel privateKeyLabel = new JLabel();
        privateKeyLabel.setText("PRIVATE KEY");
        privateKeyLabel.setFont(new Font("ARIAL", Font.PLAIN, 12));
        privateKeyLabel.setForeground(new Color(126, 133, 143));
        privateKeyLabel.setBounds(25, 70, 400, 30);

        /*
            TEXT FIELDS
        */

        JTextField privateKey = new JTextField();
        privateKey.setText(userAPI.getUserPrivateKey());
        privateKey.setBounds(25, 98, 423, 30);
        privateKey.setFont(new Font("ARIAL", Font.PLAIN, 17));
        privateKey.setBackground(new Color(9,12,20));
        privateKey.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        privateKey.setForeground(Color.white);

        /*
            BUTTONS
        */

        updateBalanceButton.setBounds(25, 12, 140, 32);
        updateBalanceButton.setFont(new Font("ARIAL", Font.BOLD, 14));
        updateBalanceButton.setBackground(new Color(247, 147, 26));
        updateBalanceButton.setForeground(Color.white);
        updateBalanceButton.setFocusable(false);
        updateBalanceButton.setBorder(null);

        /*
            ADDING
        */

        this.add(settingsLabel);
        this.add(privateKeyLabel);
        this.add(privateKey);
        this.add(settingsBottomPanel);
        settingsBottomPanel.add(updateBalanceButton);

    }

}
