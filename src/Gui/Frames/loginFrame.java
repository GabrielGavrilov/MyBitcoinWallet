package Gui.Frames;

import Gui.Panels.loginPanel;
import Gui.Panels.signupPanel;
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
    signupPanel signup = new signupPanel();

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

        signup.signupButton.addActionListener(this);
        signup.signupButton.addMouseListener(this);
        signup.haveAnAccountLabel.addMouseListener(this);

        /*
            ADDING
        */

        this.add(login);
        this.add(signup);
        signup.setVisible(false);

        this.setVisible(true);

    }

    public void sendLoginError(String message) {

        /*
                login.loginLabel.setBounds(115, 75, 300, 27);
                login.emailInputLabel.setBounds(10,128,250,20);
                login.emailInput.setBounds(10,150,278,27);
                login.passwordInputLabel.setBounds(10,193,250,20);
                login.passwordInput.setBounds(10,215,278,27);
                login.dontHaveAnAccountLabel.setBounds(60,255,200,20);
        */

        login.errorPanel.setVisible(true);
        login.errorMessage.setVisible(true);
        login.errorMessage.setText(message);

    }

    public void sendSignupError(String message) {

        signup.errorPanel.setVisible(true);
        signup.errorMessage.setVisible(true);
        signup.errorMessage.setText(message);

    }

    public void clearLoginError() {

        login.errorPanel.setVisible(false);
        login.errorMessage.setVisible(false);

    }

    public void clearSignupError() {

        signup.errorPanel.setVisible(false);
        signup.errorMessage.setVisible(false);

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
                    this.dispose();

                } else if(loginUserSuccess == false) {

                    sendLoginError("Incorrect email or password!");

                }

            } catch(Exception err) {

                sendLoginError("There has been an issue!");
                System.out.println(err);

            }

        }

        if(e.getSource() == signup.signupButton) {

            String userEmail = signup.emailInput.getText().toLowerCase();
            String userPassword = signup.passwordInput.getText();
            String passwordConfirmation = signup.confirmPasswordInput.getText();

            if(userEmail.length() <= 9) {

                sendSignupError("Must have a valid email!");

            } else if(!userPassword.equals(passwordConfirmation)) {

                sendSignupError("Passwords must match!");

            } else if(userPassword.length() <= 5) {

                sendSignupError("Password must be at least 6 chars!");

            } else {

                try {
                    boolean foundUser = database.findUser(userEmail);

                    if(foundUser == true) {

                        sendSignupError("Email is already taken!");

                    } else {

                        database.insertNewUser(userEmail, userPassword);
                        clearSignupError();
                        signup.setVisible(false);
                        login.setVisible(true);

                        sendSignupError("There has been an issue!");
                    }
                } catch(Exception err) {
                }

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == login.dontHaveAnAccountLabel) {

            clearLoginError();
            login.setVisible(false);
            signup.setVisible(true);
            this.setTitle("Sign Up :: MyBitcoinWallet");

        }

        if(e.getSource() == signup.haveAnAccountLabel) {

            clearSignupError();
            signup.setVisible(false);
            login.setVisible(true);
            this.setTitle("Log In :: MyBitcoinWallet");

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

        if(e.getSource() == login.dontHaveAnAccountLabel) {

            login.dontHaveAnAccountLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            login.dontHaveAnAccountLabel.setForeground(Color.white);

        }

        if(e.getSource() == login.loginButton) {

            login.loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            login.loginButton.setBackground(new Color(209, 118, 8));

        }

        if(e.getSource() == signup.haveAnAccountLabel) {

            signup.haveAnAccountLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            signup.haveAnAccountLabel.setForeground(Color.white);

        }

        if(e.getSource() == signup.signupButton) {

            signup.signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            signup.signupButton.setBackground(new Color(209,118,8));

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

        if(e.getSource() == signup.haveAnAccountLabel) {
            signup.haveAnAccountLabel.setForeground(new Color(126, 133, 143));
        }

        if(e.getSource() == signup.signupButton) {
            signup.signupButton.setBackground(new Color(247,147,26));
        }

    }
}
