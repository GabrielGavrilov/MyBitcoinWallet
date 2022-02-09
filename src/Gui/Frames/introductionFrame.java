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

    public introductionFrame() throws InterruptedException  {

        this.setTitle("MyBitcoinWallet");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        /*
            LABELS
        */

        JLabel signupText = new JLabel();
        signupText.setText("Sign Up");
        signupText.setFont(new Font("ARIAL", Font.PLAIN, 23));
        signupText.setBounds(150, 10, 400, 30);

        alreadyHaveAnAccount.setBounds(105, 136, 180, 30);
        alreadyHaveAnAccount.setText("Already have an account?");
        alreadyHaveAnAccount.setFont(new Font("ARIAL", Font.PLAIN, 16));
        alreadyHaveAnAccount.addMouseListener(this);

        /*
            PANELS
        */

        signupPanel pSignup = new signupPanel();

        /*
            BUTTONS
        */

        signupBtn.setBounds(105,175, 180, 25);
        signupBtn.setFont(new Font("ARIAL", Font.PLAIN, 15));
        signupBtn.setFocusable(false);
        signupBtn.addMouseListener(this);

        /*
            ADDING
        */

        this.add(signupText);
        this.add(pSignup);
        this.add(alreadyHaveAnAccount);
        this.add(signupBtn);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
