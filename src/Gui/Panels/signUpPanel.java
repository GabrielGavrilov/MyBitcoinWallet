package Gui.Panels;

import Program.mongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpPanel extends JPanel implements ActionListener {

    JPanel errorPanel;
    JLabel errorLabel;
    JTextField emailInput;
    JTextField passwordInput;
    JTextField passwordConfirmationInput;
    JButton signUpButton;

    mongoDatabase database = new mongoDatabase();

    public signUpPanel() {

        this.setLayout(null);
        this.setBounds(0,0,400,250);

        /*
            JLabels
        */

        errorLabel = new JLabel();
        errorLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        errorLabel.setVisible(false);

        /*
            PANEL
        */

        errorPanel = new JPanel();
        errorPanel.setLayout(new GridBagLayout());
        errorPanel.setBackground(new Color(255, 99, 71));
        errorPanel.setBounds(20, 10, 350, 50);
        errorPanel.setVisible(false);

        /*
            TEXT FIELDS
        */

        emailInput = new JTextField();
        passwordInput = new JTextField();
        passwordConfirmationInput = new JTextField();

        emailInput.setBounds(20, 20, 350, 25);
        emailInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        emailInput.setText("Enter your email");

        passwordInput.setBounds(20, 55, 350, 25);
        passwordInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        passwordInput.setText("Choose a strong password");

        passwordConfirmationInput.setBounds(20, 90, 350, 25);
        passwordConfirmationInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        passwordConfirmationInput.setText("Confirm password");

        /*
            BUTTONS
        */

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(145, 180, 100, 25);
        signUpButton.setFont(new Font("ARIAL", Font.PLAIN, 15));
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);

        /*
            ADDING
        */

        errorPanel.add(errorLabel);
        this.add(errorPanel);
        this.add(emailInput);
        this.add(passwordInput);
        this.add(passwordConfirmationInput);
        this.add(signUpButton);

    }

    public void sendError(String message) {

        emailInput.setBounds(20,70,350,25);
        passwordInput.setBounds(20,105,350,25);
        passwordConfirmationInput.setBounds(20,140,350,25);

        errorPanel.setVisible(true);
        errorLabel.setText(message);
        errorLabel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signUpButton) {

            String emailInputText = emailInput.getText();
            String passwordInputText = passwordInput.getText();
            String passwordConfirmationInputText = passwordConfirmationInput.getText();

            if(!emailInputText.contains("@") || emailInputText.contains(" ") || !emailInputText.contains(".")) {

                sendError("Email must be valid!");

            } else if(!passwordInputText.equals(passwordConfirmationInputText)) {

                sendError("Passwords must match!");

            } else {

                String userEmail = emailInput.getText();
                String userPassword = passwordInput.getText();

                database.insertNewUser(userEmail, userPassword);

                System.out.println(userEmail + " has signed up!");

            }

        }

    }
}
