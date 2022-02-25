package Gui.Frames;

import Gui.Panels.*;
import Program.mongoDatabase;
import Program.userAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class walletFrame extends JFrame implements ActionListener, MouseListener {

    userAPI userAPI = new userAPI();
    mongoDatabase database = new mongoDatabase();

    /*
        PANELS
    */

    sideMenuPanel sideMenu = new sideMenuPanel();
    overviewMenuPanel overviewPanel = new overviewMenuPanel();
    sendMenuPanel sendPanel = new sendMenuPanel();
    receiveMenuPanel receivePanel = new receiveMenuPanel();
    settingsMenuPanel settingsPanel = new settingsMenuPanel();

    JPanel errorPanel = new JPanel();

    /*
        LABELS
    */

    JLabel errorMsg = new JLabel();

    /*
        MENU CHECK
    */

    boolean isOnOverviewMenu = true;
    boolean isOnSendMenu = false;
    boolean isOnReceiveMenu = false;
    boolean isOnSettingsMenu = false;

    public walletFrame() throws InterruptedException {

        this.setLayout(null);
        this.setSize(675, 500);
        this.getContentPane().setBackground(new Color(20, 24, 34));
        this.setTitle("Overview :: MyBitcoinWallet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        /*
            ADDING LISTENERS
        */

        sideMenu.menuOverview.addMouseListener(this);
        sideMenu.menuSend.addMouseListener(this);
        sideMenu.menuReceive.addMouseListener(this);
        sideMenu.menuSettings.addMouseListener(this);

        sendPanel.sendMaxButton.addActionListener(this);
        sendPanel.sendMaxButton.addMouseListener(this);
        sendPanel.sendButton.addActionListener(this);
        sendPanel.sendButton.addMouseListener(this);

        settingsPanel.updateBalanceButton.addMouseListener(this);
        settingsPanel.updateBalanceButton.addActionListener(this);
        settingsPanel.deleteAccountButton.addMouseListener(this);
        settingsPanel.deleteAccountButton.addActionListener(this);

        /*
            PANELS
        */

        errorPanel.setBounds(190,0,485,50);
        errorPanel.setLayout(new GridBagLayout());

        /*
            LABELS
        */

        errorMsg.setFont(new Font("ARIAL", Font.PLAIN, 17));
        errorMsg.setForeground(Color.WHITE);

        /*
            ADDING
        */

        this.add(sideMenu);

        this.add(errorPanel);
        errorPanel.setVisible(false);
        errorPanel.add(errorMsg);
        errorMsg.setVisible(false);

        this.add(overviewPanel);
        overviewPanel.setVisible(true);

        this.add(sendPanel);
        sendPanel.setVisible(false);

        this.add(receivePanel);
        receivePanel.setVisible(false);

        this.add(settingsPanel);
        settingsPanel.setVisible(false);

        this.setVisible(true);

    }

    public void showOverviewPanel() {

        this.setTitle("Overview :: MyBitcoinWallet");

        this.isOnOverviewMenu = true;
        this.isOnSendMenu = false;
        this.isOnReceiveMenu = false;
        this.isOnSettingsMenu = false;

        overviewPanel.setVisible(true);
        sendPanel.setVisible(false);
        receivePanel.setVisible(false);
        settingsPanel.setVisible(false);

        sideMenu.menuOverview.setBackground(new Color(19, 22, 31));
        sideMenu.overviewLabel.setForeground(Color.white);
        sideMenu.menuOrangeOverview.setVisible(true);

        sideMenu.menuSend.setBackground(new Color(9, 12, 20));
        sideMenu.sendLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeSend.setVisible(false);

        sideMenu.menuReceive.setBackground(new Color(9, 12, 20));
        sideMenu.receiveLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeReceive.setVisible(false);

        sideMenu.menuSettings.setBackground(new Color(9, 12, 20));
        sideMenu.settingsLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeSettings.setVisible(false);

    }

    public void showSendPanel() {

        this.setTitle("Send :: MyBitcoinWallet");

        this.isOnOverviewMenu = false;
        this.isOnSendMenu = true;
        this.isOnReceiveMenu = false;
        this.isOnSettingsMenu = false;

        overviewPanel.setVisible(false);
        sendPanel.setVisible(true);
        receivePanel.setVisible(false);
        settingsPanel.setVisible(false);

        sideMenu.menuOverview.setBackground(new Color(9, 12, 20));
        sideMenu.overviewLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeOverview.setVisible(false);

        sideMenu.menuSend.setBackground(new Color(19, 22, 31));
        sideMenu.sendLabel.setForeground(Color.white);
        sideMenu.menuOrangeSend.setVisible(true);

        sideMenu.menuReceive.setBackground(new Color(9, 12, 20));
        sideMenu.receiveLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeReceive.setVisible(false);

        sideMenu.menuSettings.setBackground(new Color(9, 12, 20));
        sideMenu.settingsLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeSettings.setVisible(false);

    }

    public void showReceivePanel() {

        this.setTitle("Receive :: MyBitcoinWallet");

        this.isOnOverviewMenu = false;
        this.isOnSendMenu = false;
        this.isOnReceiveMenu = true;
        this.isOnSettingsMenu = false;

        overviewPanel.setVisible(false);
        sendPanel.setVisible(false);
        receivePanel.setVisible(true);
        settingsPanel.setVisible(false);

        sideMenu.menuOverview.setBackground(new Color(9, 12, 20));
        sideMenu.overviewLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeOverview.setVisible(false);

        sideMenu.menuSend.setBackground(new Color(9, 12, 20));
        sideMenu.sendLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeSend.setVisible(false);

        sideMenu.menuReceive.setBackground(new Color(19, 22, 31));
        sideMenu.receiveLabel.setForeground(Color.white);
        sideMenu.menuOrangeReceive.setVisible(true);

        sideMenu.menuSettings.setBackground(new Color(9, 12, 20));
        sideMenu.settingsLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeSettings.setVisible(false);

    }

    public void showSettingsPanel() {

        this.setTitle("Settings :: MyBitcoinWallet");

        this.isOnOverviewMenu = false;
        this.isOnSendMenu = false;
        this.isOnReceiveMenu = false;
        this.isOnSettingsMenu = true;

        overviewPanel.setVisible(false);
        sendPanel.setVisible(false);
        receivePanel.setVisible(false);
        settingsPanel.setVisible(true);

        sideMenu.menuOverview.setBackground(new Color(9, 12, 20));
        sideMenu.overviewLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeOverview.setVisible(false);

        sideMenu.menuSend.setBackground(new Color(9, 12, 20));
        sideMenu.sendLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeSend.setVisible(false);

        sideMenu.menuReceive.setBackground(new Color(9, 12, 20));
        sideMenu.receiveLabel.setForeground(new Color(126, 133, 143));
        sideMenu.menuOrangeReceive.setVisible(false);

        sideMenu.menuSettings.setBackground(new Color(19, 22, 31));
        sideMenu.settingsLabel.setForeground(Color.white);
        sideMenu.menuOrangeSettings.setVisible(true);


    }

    public void sendError(String errorMessage) {

        if(isOnSendMenu == true) {

            sendPanel.sendLabel.setBounds(25,75,400,30);
            sendPanel.sendBitcoinOnlyLabel.setBounds(25,105,400,30);
            sendPanel.bitcoinAddressLabel.setBounds(25,150,400,30);
            sendPanel.bitcoinAddress.setBounds(25,178,423,30);
            sendPanel.amountToSendLabel.setBounds(25, 228, 400,30);
            sendPanel.amountToSend.setBounds(25,256,300,30);
            sendPanel.sendMaxButton.setBounds(335,256,113,30);
            errorPanel.setBackground(new Color(255,99,71));

            errorPanel.setVisible(true);
            errorMsg.setText(errorMessage);
            errorMsg.setVisible(true);

        }

    }

    public void removeError() {

        sendPanel.sendLabel.setBounds(25,25,400,30);
        sendPanel.sendBitcoinOnlyLabel.setBounds(25,55,400,30);
        sendPanel.bitcoinAddressLabel.setBounds(25,100,400,30);
        sendPanel.bitcoinAddress.setBounds(25,128,423,30);
        sendPanel.amountToSendLabel.setBounds(25, 178, 400,30);
        sendPanel.amountToSend.setBounds(25,206,300,30);
        sendPanel.sendMaxButton.setBounds(335,206,113,30);
        errorPanel.setBackground(new Color(255,99,71));

        errorPanel.setVisible(false);
        errorMsg.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == sendPanel.sendMaxButton) {
            sendPanel.amountToSend.setText(userAPI.getUserBtcBalance());
        }

        if(e.getSource() == sendPanel.sendButton) {

            try {

                Double amountOfBitcoin = Double.parseDouble(sendPanel.amountToSend.getText());
                Double userBitcoinBalance = Double.parseDouble(userAPI.getUserBtcBalance());

                if(amountOfBitcoin > userBitcoinBalance) {

                    sendError("You have insufficient funds!");

                } else if(amountOfBitcoin <= 0.00012999) {

                    sendError("You must send at least 0.00013 Bitcoin!");

                } else {

                    database.insertNewSendOrder(userAPI.getUserPublicWallet(), sendPanel.bitcoinAddress.getText(), sendPanel.amountToSend.getText());
                    sendError("Send order created - please allow us up to 24 hours to process the order.");
                    errorPanel.setBackground(new Color(99,224,120));
                    errorMsg.setFont(new Font("ARIAL", Font.PLAIN, 14));

                }


            } catch(Exception err) {

                sendError("There has been an issue!");

            }

        }

        if(e.getSource() == settingsPanel.updateBalanceButton) {

            database.updateUserBalance(userAPI.getUserPublicWallet(), userAPI.getUserBtcBalance(), userAPI.getUserUsdBalance());
            loginFrame login = new loginFrame();
            this.dispose();

        }

        if(e.getSource() == settingsPanel.deleteAccountButton) {

            database.deleteUser(userAPI.getUserPublicWallet());
            loginFrame login = new loginFrame();
            this.dispose();

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == sideMenu.menuOverview) {
            removeError();
            showOverviewPanel();
        }

        if(e.getSource() == sideMenu.menuSend) {
            removeError();
            showSendPanel();
        }

        if(e.getSource() == sideMenu.menuReceive) {
            removeError();
            showReceivePanel();
        }

        if(e.getSource() == sideMenu.menuSettings) {
            removeError();
            showSettingsPanel();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource() == sendPanel.sendMaxButton) {
            sendPanel.sendMaxButton.setBackground(new Color(209, 118, 8));
            sendPanel.sendMaxButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == sendPanel.sendButton) {
            sendPanel.sendButton.setBackground(new Color(209, 118, 8));
            sendPanel.sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == settingsPanel.updateBalanceButton) {
            settingsPanel.updateBalanceButton.setBackground(new Color(209, 118, 8));
            settingsPanel.updateBalanceButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == settingsPanel.deleteAccountButton) {
            settingsPanel.deleteAccountButton.setBackground(new Color(255,99,71));
            settingsPanel.deleteAccountButton.setForeground(Color.white);
            settingsPanel.deleteAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(isOnOverviewMenu == true) {

            if(e.getSource() == sideMenu.menuSend) {
                sideMenu.menuSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.sendLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuReceive) {
                sideMenu.menuReceive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.receiveLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuSettings) {
                sideMenu.menuSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.settingsLabel.setForeground(new Color(247, 147, 26));
            }

        }

        if(isOnSendMenu == true) {

            if(e.getSource() == sideMenu.menuOverview) {
                sideMenu.menuOverview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.overviewLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuReceive) {
                sideMenu.menuReceive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.receiveLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuSettings) {
                sideMenu.menuSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.settingsLabel.setForeground(new Color(247, 147, 26));
            }

        }

        if(isOnReceiveMenu == true) {

            if(e.getSource() == sideMenu.menuOverview) {
                sideMenu.menuOverview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.overviewLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuSend) {
                sideMenu.menuSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.sendLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuSettings) {
                sideMenu.menuSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.settingsLabel.setForeground(new Color(247, 147, 26));
            }

        }

        if(isOnSettingsMenu == true) {

            if(e.getSource() == sideMenu.menuOverview) {
                sideMenu.menuOverview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.overviewLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuSend) {
                sideMenu.menuSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.sendLabel.setForeground(new Color(247, 147, 26));
            }

            if(e.getSource() == sideMenu.menuReceive) {
                sideMenu.menuReceive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                sideMenu.receiveLabel.setForeground(new Color(247, 147, 26));
            }

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if(e.getSource() == sendPanel.sendMaxButton) {
            sendPanel.sendMaxButton.setBackground(new Color(247, 147, 26));
        }

        if(e.getSource() == sendPanel.sendButton) {
            sendPanel.sendButton.setBackground(new Color(247, 147, 26));
        }

        if(e.getSource() == settingsPanel.updateBalanceButton) {
            settingsPanel.updateBalanceButton.setBackground(new Color(247,147,26));
        }

        if(e.getSource() == settingsPanel.deleteAccountButton) {
            settingsPanel.deleteAccountButton.setForeground(new Color(255,99,71));
            settingsPanel.deleteAccountButton.setBackground(new Color(35, 39, 51));
        }

        if(isOnOverviewMenu == true) {

            if(e.getSource() == sideMenu.menuSend) {
                sideMenu.sendLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuReceive) {
                sideMenu.receiveLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuSettings) {
                sideMenu.settingsLabel.setForeground(new Color(126, 133, 143));
            }

        }

        if(isOnSendMenu == true) {

            if(e.getSource() == sideMenu.menuOverview) {
                sideMenu.overviewLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuReceive) {
                sideMenu.receiveLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuSettings) {
                sideMenu.settingsLabel.setForeground(new Color(126, 133, 143));
            }

        }

        if(isOnReceiveMenu == true) {

            if(e.getSource() == sideMenu.menuOverview) {
                sideMenu.overviewLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuSend) {
                sideMenu.sendLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuSettings) {
                sideMenu.settingsLabel.setForeground(new Color(126, 133, 143));
            }

        }

        if(isOnSettingsMenu) {

            if(e.getSource() == sideMenu.menuOverview) {
                sideMenu.overviewLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuSend) {
                sideMenu.sendLabel.setForeground(new Color(126, 133, 143));
            }

            if(e.getSource() == sideMenu.menuReceive) {
                sideMenu.receiveLabel.setForeground(new Color(126, 133, 143));
            }

        }

    }
}
