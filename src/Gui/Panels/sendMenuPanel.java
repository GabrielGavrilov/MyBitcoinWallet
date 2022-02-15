package Gui.Panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class sendMenuPanel extends JPanel {

    /*
        PUBLIC TEXT FIELDS
    */

    JTextField bitcoinAddress = new JTextField();
    JTextField amountToSend = new JTextField();

    public sendMenuPanel() {

        this.setBackground(new Color(20, 24, 34));
        this.setLayout(null);
        this.setBounds(190,0,485,500);

        /*
            LABELS
        */

        JLabel sendLabel = new JLabel();
        sendLabel.setText("Send");
        sendLabel.setFont(new Font("ARIAL", Font.PLAIN, 27));
        sendLabel.setForeground(Color.white);
        sendLabel.setBounds(25,25,400,30);

        JLabel sendBitcoinOnlyLabel = new JLabel();
        sendBitcoinOnlyLabel.setText("Send only to Bitcoin (BTC) addresses.");
        sendBitcoinOnlyLabel.setFont(new Font("ARIAL", Font.BOLD, 13));
        sendBitcoinOnlyLabel.setForeground(Color.white);
        sendBitcoinOnlyLabel.setBounds(25,55,400,30);

        JLabel bitcoinAddressLabel = new JLabel();
        bitcoinAddressLabel.setText("BITCOIN ADDRESS");
        bitcoinAddressLabel.setFont(new Font("ARIAL", Font.PLAIN, 12));
        bitcoinAddressLabel.setForeground(new Color(126, 133, 143));
        bitcoinAddressLabel.setBounds(25, 100, 400, 30);

        JLabel amountToSendLabel = new JLabel();
        amountToSendLabel.setText("AMOUNT TO SEND");
        amountToSendLabel.setFont(new Font("ARIAL", Font.PLAIN, 12));
        amountToSendLabel.setForeground(new Color(126, 133, 143));
        amountToSendLabel.setBounds(25, 178, 400, 30);

        /*
            TEXT FIELDS
        */

        bitcoinAddress.setText(" Address");
        bitcoinAddress.setBounds(25, 128, 423, 30);
        bitcoinAddress.setFont(new Font("ARIAL", Font.PLAIN, 17));
        bitcoinAddress.setBackground(new Color(9,12,20));
        bitcoinAddress.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        bitcoinAddress.setForeground(new Color(43, 47, 58));

        /*
            ADD
        */

        this.add(sendLabel);
        this.add(sendBitcoinOnlyLabel);
        this.add(bitcoinAddressLabel);
        this.add(bitcoinAddress);
        this.add(amountToSendLabel);

    }

}
