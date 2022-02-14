package Gui.Frames;

import Gui.Panels.sideMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class walletFrame extends JFrame implements ActionListener, MouseListener {

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
            ADDING LISTENERS
        */

        sideMenu.menuOverview.addMouseListener(this);
        sideMenu.menuSend.addMouseListener(this);
        sideMenu.menuReceive.addMouseListener(this);
        sideMenu.menuSettings.addMouseListener(this);

        /*
            ADDING
        */

        this.add(sideMenu);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == sideMenu.menuSend) {

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

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource() == sideMenu.menuOverview) {
            sideMenu.menuOverview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == sideMenu.menuSend) {
            sideMenu.menuSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == sideMenu.menuReceive) {
            sideMenu.menuReceive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == sideMenu.menuSettings) {
            sideMenu.menuSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
