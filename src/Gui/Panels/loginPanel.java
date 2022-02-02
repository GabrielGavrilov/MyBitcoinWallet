package Gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPanel extends JPanel implements ActionListener {

    JPanel errorPanel;
    JLabel errorLabel;
    JTextField emailLoginInput;
    JTextField passwordLoginInput;
    JButton loginButton;
    JLabel dontHaveAnAccountLabel;

    public loginPanel() {

        this.setLayout(null);
        this.setBounds(0,0,400,290);

        /*
            PANELS
        */

        errorPanel = new JPanel();
        errorPanel.setLayout(new GridBagLayout());
        errorPanel.setBackground(new Color(255, 99, 71));
        errorPanel.setBounds(20, 10, 350, 50);
        errorPanel.setVisible(false);

        /*
            TEXT FIELDS
        */

        emailLoginInput = new JTextField();
        passwordLoginInput = new JTextField();

        emailLoginInput.setBounds(20,20,350,25);
        emailLoginInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        emailLoginInput.setText("Enter your email");

        passwordLoginInput.setBounds(20,55, 350, 25);
        passwordLoginInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        passwordLoginInput.setText("Enter your password");

        /*
            BUTTONS
        */

        loginButton = new JButton("Log In");
        loginButton.setFocusable(false);
        loginButton.setBounds(145, 215, 100,25);
        loginButton.setFont(new Font("ARIAL", Font.PLAIN, 15));
        loginButton.addActionListener(this);

        /*
            LABELS
        */

        errorLabel = new JLabel();
        errorLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        errorLabel.setVisible(false);

        dontHaveAnAccountLabel = new JLabel();
        dontHaveAnAccountLabel.setText("Don't have an account?");
        dontHaveAnAccountLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        dontHaveAnAccountLabel.setBounds(115, 95, 180,20);

        /*
            ADDING
        */

        this.add(errorPanel);
        errorPanel.add(errorLabel);
        this.add(emailLoginInput);
        this.add(passwordLoginInput);
        this.add(dontHaveAnAccountLabel);
        this.add(loginButton);

    }

    public void sendError(String message) {

        emailLoginInput.setBounds(20, 70, 350, 25);
        passwordLoginInput.setBounds(20, 105, 350, 25);
        dontHaveAnAccountLabel.setBounds(115, 140, 180, 20);

        errorPanel.setVisible(true);
        errorLabel.setText(message);
        errorLabel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginButton) {

            sendError("Test message!");

        }

    }
}
