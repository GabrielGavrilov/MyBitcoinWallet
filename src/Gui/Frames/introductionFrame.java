package Gui.Frames;

import Gui.Panels.signupPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class introductionFrame extends JFrame implements ActionListener, MouseListener {

    static JLabel alreadyHaveAnAccount = new JLabel();
    static JButton signupBtn = new JButton("Sign Up");
    static JLabel signupText;
    static JPanel errorPanel;
    static JLabel errorMessage;

    static signupPanel pSignup = new signupPanel();

    public introductionFrame() throws InterruptedException  {

        this.setTitle("Sign Up :: MyBitcoinWallet");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        /*
            LABELS
        */

        signupText = new JLabel();
        signupText.setText("Sign Up");
        signupText.setFont(new Font("ARIAL", Font.PLAIN, 23));
        signupText.setBounds(160, 10, 400, 30);

        alreadyHaveAnAccount.setBounds(110, 136, 180, 30);
        alreadyHaveAnAccount.setText("Already have an account?");
        alreadyHaveAnAccount.setFont(new Font("ARIAL", Font.PLAIN, 16));
        alreadyHaveAnAccount.addMouseListener(this);

        errorMessage = new JLabel();
        errorMessage.setFont(new Font("ARIAL", Font.PLAIN, 17));

        /*
            PANELS
        */

        errorPanel = new JPanel();
        errorPanel.setBackground(new Color(255, 99, 71));
        errorPanel.setBounds(10,10,370,65);
        errorPanel.setLayout(new GridBagLayout());

        /*
            BUTTONS
        */

        signupBtn.setBounds(110,175, 180, 25);
        signupBtn.setFont(new Font("ARIAL", Font.PLAIN, 15));
        signupBtn.setFocusable(false);
        signupBtn.addMouseListener(this);
        signupBtn.addActionListener(this);

        /*
            ADDING
        */

        this.add(signupText);
        this.add(pSignup);
        this.add(alreadyHaveAnAccount);
        this.add(signupBtn);

        this.setVisible(true);

    }

    void sendError(String errMessage) {

        this.setSize(400, 325);

        signupText.setBounds(160, 85, 400, 30);
        pSignup.setBounds(0, 120, 400, 100);
        alreadyHaveAnAccount.setBounds(110, 211, 180, 30);
        signupBtn.setBounds(110,250, 180, 25);

        this.add(errorPanel);
        errorPanel.add(errorMessage);
        errorMessage.setText(errMessage);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signupBtn) {

            String signupEmail = pSignup.userEmailInput.getText();

            if(!signupEmail.contains("@")) {
                sendError("Must have a valid email!");
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == alreadyHaveAnAccount) {


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

        if(e.getSource() == alreadyHaveAnAccount) {
            alreadyHaveAnAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        if(e.getSource() == signupBtn) {
            signupBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
