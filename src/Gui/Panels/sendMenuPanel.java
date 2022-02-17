package Gui.Panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class sendMenuPanel extends JPanel {

    /*
        PUBLIC TEXT FIELDS
    */

    public JTextField bitcoinAddress = new JTextField();
    public JTextField amountToSend = new JTextField();

    /*
        PUBLIC BUTTONS
    */

    public JButton sendMaxButton = new JButton("SEND MAX");
    public JButton sendButton = new JButton("SEND");

    public sendMenuPanel() throws InterruptedException {

        this.setBackground(new Color(20, 24, 34));
        this.setLayout(null);
        this.setBounds(190,0,485,500);

        /*
            Panels
        */

        JPanel confirmSendPanel = new JPanel();
        confirmSendPanel.setBackground(new Color(35, 39, 51));
        confirmSendPanel.setBounds(0,415, 485, 75);
        confirmSendPanel.setLayout(null);

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

        amountToSend.setText(" Amount");
        amountToSend.setBounds(25, 206, 300, 30);
        amountToSend.setFont(new Font("ARIAL", Font.PLAIN, 17));
        amountToSend.setBackground(new Color(9,12,20));
        amountToSend.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        amountToSend.setForeground(new Color(43, 47, 58));

        /*
            BUTTONS
        */

        sendMaxButton.setFont(new Font("ARIAL", Font.BOLD, 14));
        sendMaxButton.setBackground(new Color(247, 147, 26));
        sendMaxButton.setForeground(Color.white);
        sendMaxButton.setFocusable(false);
        sendMaxButton.setBounds(335,206, 113, 30);
        sendMaxButton.setBorder(null);

        sendButton.setFont(new Font("ARIAL", Font.BOLD, 14));
        sendButton.setBackground(new Color(247, 147, 26));
        sendButton.setForeground(Color.white);
        sendButton.setFocusable(false);
        sendButton.setBounds(375,12, 75, 33);
        sendButton.setBorder(null);

        /*
            ADD
        */

        this.add(sendLabel);
        this.add(sendBitcoinOnlyLabel);
        this.add(bitcoinAddressLabel);
        this.add(bitcoinAddress);
        this.add(amountToSendLabel);
        this.add(sendMaxButton);
        this.add(amountToSend);

        this.add(confirmSendPanel);
        confirmSendPanel.add(sendButton);

    }

}
