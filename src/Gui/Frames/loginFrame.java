package Gui.Frames;

import Gui.Panels.loginPanel;
import Program.mongoDatabase;
import Program.userAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class loginFrame extends JFrame implements ActionListener, MouseListener {

    static mongoDatabase database = new mongoDatabase();
    static userAPI user = new userAPI();

    /*
        PANELS
    */

    loginPanel login = new loginPanel();

    public loginFrame() {

        this.setLayout(null);
        this.setSize(675, 500);
        this.getContentPane().setBackground(new Color(9, 12, 20));
        this.setTitle("Log In :: MyBitcoinWallet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        /*
            ADDING LISTENERS
        */

        login.loginButton.addActionListener(this);
        login.loginButton.addMouseListener(this);
        login.dontHaveAnAccountLabel.addMouseListener(this);

        /*
            ADDING
        */

        this.add(login);

        this.setVisible(true);

    }

    public void sendError(String message) {

        login.loginLabel.setBounds(115, 75, 300, 27);
        login.emailInputLabel.setBounds(10,128,250,20);
        login.emailInput.setBounds(10,150,278,27);
        login.passwordInputLabel.setBounds(10,193,250,20);
        login.passwordInput.setBounds(10,215,278,27);
        login.dontHaveAnAccountLabel.setBounds(60,255,200,20);

        login.errorPanel.setVisible(true);
        login.errorMessage.setVisible(true);
        login.errorMessage.setText(message);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login.loginButton) {

            String userEmail = login.emailInput.getText().toLowerCase();
            String userPassword = login.passwordInput.getText();

            try {

                boolean loginUserSuccess = database.loginUser(userEmail, userPassword);

                if(loginUserSuccess == true) {

                    walletFrame wallet = new walletFrame();
                    this.setVisible(false);

                } else if(loginUserSuccess == false) {

                    sendError("Incorrect email or password.");

                }

            } catch(Exception err) {

                sendError("There has been an issue login in.");
                System.out.println(err);

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource() == login.dontHaveAnAccountLabel) {

            login.dontHaveAnAccountLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            login.dontHaveAnAccountLabel.setForeground(Color.white);

        }

        if(e.getSource() == login.loginButton) {

            login.loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            login.loginButton.setBackground(new Color(209, 118, 8));

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if(e.getSource() == login.dontHaveAnAccountLabel) {
            login.dontHaveAnAccountLabel.setForeground(new Color(126, 133, 143));
        }

        if(e.getSource() == login.loginButton) {
            login.loginButton.setBackground(new Color(247, 147, 26));
        }

    }
}
