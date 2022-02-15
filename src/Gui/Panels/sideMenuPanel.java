package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import java.awt.*;

public class sideMenuPanel extends JPanel {

    static userAPI user = new userAPI();

    /*
        PUBLIC LABELS
    */

    public static JLabel btcWalletBalance = new JLabel();
    public static JLabel usdWalletBalance = new JLabel();

    public JLabel overviewLabel = new JLabel();
    public JLabel sendLabel = new JLabel();
    public JLabel receiveLabel = new JLabel();
    public JLabel settingsLabel = new JLabel();

    /*
        MENU PANELS
    */

    public JPanel menuOverview = new JPanel();
    public JPanel menuSend = new JPanel();
    public JPanel menuReceive = new JPanel();
    public JPanel menuSettings = new JPanel();

    public JPanel menuOrangeOverview = new JPanel();
    public JPanel menuOrangeSend = new JPanel();
    public JPanel menuOrangeReceive = new JPanel();
    public JPanel menuOrangeSettings = new JPanel();

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
        totalBalanceLabel.setBounds(20,20,150,20);

        btcWalletBalance.setText(user.getUserBtcBalance()); // CHANGE THIS LATER
        btcWalletBalance.setFont(new Font("ARIAL", Font.BOLD, 16));
        btcWalletBalance.setForeground(Color.white);
        btcWalletBalance.setBounds(20,55,150,20);

        usdWalletBalance.setText(user.getUserUsdBalance());
        usdWalletBalance.setFont(new Font("ARIAL", Font.BOLD, 11));
        usdWalletBalance.setForeground(new Color(126, 133, 143));
        usdWalletBalance.setBounds(20, 75, 150, 20);

        JLabel btcLabel = new JLabel();
        btcLabel.setText("BTC");
        btcLabel.setFont(new Font("ARIAL", Font.PLAIN, 9));
        btcLabel.setBounds(btcWalletBalance.getX() + 89, 53, 150, 20);
        btcLabel.setForeground(new Color(126, 133, 143));

        JLabel usdLabel= new JLabel();
        usdLabel.setText("USD");
        usdLabel.setFont(new Font("ARIAL", Font.PLAIN, 9));
        usdLabel.setBounds(usdWalletBalance.getX() + 35, 75, 150, 20);
        usdLabel.setForeground(new Color(126, 133, 143));

        overviewLabel.setText("Overview");
        overviewLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
        overviewLabel.setForeground(Color.white);
        overviewLabel.setBounds(45,0,190,50);

        sendLabel.setText("Send");
        sendLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
        sendLabel.setForeground(new Color(126, 133, 143));
        sendLabel.setBounds(45, 0, 190, 50);

        receiveLabel.setText("Receive");
        receiveLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
        receiveLabel.setForeground(new Color(126, 133, 143));
        receiveLabel.setBounds(45, 0, 190, 50);

        settingsLabel.setText("Settings");
        settingsLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
        settingsLabel.setForeground(new Color(126, 133, 143));
        settingsLabel.setBounds(45, 0, 190, 50);

        /*
            PANELS
        */

        menuOrangeOverview.setBounds(0, 0, 3, 50);
        menuOrangeOverview.setBackground(new Color(247, 147, 26));
        menuOrangeOverview.setVisible(true);

        menuOrangeSend.setBounds(0, 0, 3, 50);
        menuOrangeSend.setBackground(new Color(247, 147, 26));
        menuOrangeSend.setVisible(false);

        menuOrangeReceive.setBounds(0, 0, 3, 50);
        menuOrangeReceive.setBackground(new Color(247, 147, 26));
        menuOrangeReceive.setVisible(false);

        menuOrangeSettings.setBounds(0, 0, 3, 50);
        menuOrangeSettings.setBackground(new Color(247, 147, 26));
        menuOrangeSettings.setVisible(false);

        menuOverview.setBounds(0,150,190, 50);
        menuOverview.setBackground(new Color(19, 22, 31));
        menuOverview.setLayout(null);
        menuOverview.add(overviewLabel);
        menuOverview.add(menuOrangeOverview);

        menuSend.setBounds(0,200,190,50);
        menuSend.setBackground(new Color(9, 12, 20));
        menuSend.setLayout(null);
        menuSend.add(sendLabel);
        menuSend.add(menuOrangeSend);

        menuReceive.setBounds(0, 250, 190, 50);
        menuReceive.setBackground(new Color(9, 12, 20));
        menuReceive.setLayout(null);
        menuReceive.add(receiveLabel);
        menuReceive.add(menuOrangeReceive);

        menuSettings.setBounds(0,300,190,50);
        menuSettings.setBackground(new Color(9, 12, 20));
        menuSettings.setLayout(null);
        menuSettings.add(settingsLabel);
        menuSettings.add(menuOrangeSettings);

        /*
            ADDING
        */

        this.add(totalBalanceLabel);
        this.add(btcWalletBalance);
        this.add(btcLabel);
        this.add(usdWalletBalance);
        this.add(usdLabel);

        this.add(menuOverview);
        this.add(menuSend);
        this.add(menuReceive);
        this.add(menuSettings);

    }

}
