package Gui.Panels;

import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class loginPanel extends JPanel {

    /*
        PUBLIC PANELS
    */

    public JPanel errorPanel = new JPanel();

    /*
        PUBLIC LABELS
    */

    public JLabel errorMessage = new JLabel();
    public JLabel loginLabel = new JLabel();
    public JLabel emailInputLabel = new JLabel();
    public JLabel passwordInputLabel = new JLabel();
    public JLabel dontHaveAnAccountLabel = new JLabel();

    /*
       PUBLIC TEXT FIELDS
    */

    public static JTextField emailInput = new JTextField();
    public static JPasswordField passwordInput = new JPasswordField();

    /*
       PUBLIC BUTTONS
    */

    public static JButton loginButton = new JButton("Log In");

    public loginPanel() {

        this.setLayout(null);
        this.setBackground(new Color(20, 24, 34));
        this.setBounds(180, 35, 300, 400);

        /*
            PANELS
        */

        errorPanel.setBounds(0,0,300,50);
        errorPanel.setBackground(new Color(255,99,71));
        errorPanel.setLayout(new GridBagLayout());

        /*
            LABELS
        */

        errorMessage.setFont(new Font("ARIAL", Font.PLAIN, 17));
        errorMessage.setForeground(Color.white);

        loginLabel.setText("Log In");
        loginLabel.setFont(new Font("ARIAL", Font.BOLD, 25));
        loginLabel.setBounds(115, 25, 300, 27);
        loginLabel.setForeground(Color.white);

        emailInputLabel.setText("Enter your login email:");
        emailInputLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        emailInputLabel.setForeground(new Color(126, 133, 143));
        emailInputLabel.setBounds(10, 78, 250, 20);

        passwordInputLabel.setText("Enter your login password:");
        passwordInputLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        passwordInputLabel.setForeground(new Color(126,133,143));
        passwordInputLabel.setBounds(10, 143, 250, 20);

        dontHaveAnAccountLabel.setText("Don't have an account?");
        dontHaveAnAccountLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
        dontHaveAnAccountLabel.setForeground(new Color(126,133,143));
        dontHaveAnAccountLabel.setBounds(60, 215, 200, 20);

        /*
            TEXT FIELDS
        */

        emailInput.setBounds(10, 100, 278, 27);
        emailInput.setFont(new Font("ARIAL", Font.PLAIN, 17));
        emailInput.setBackground(new Color(9, 12, 20));
        emailInput.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        emailInput.setForeground(new Color(43, 47, 58));

        passwordInput.setBounds(10, 165, 278, 27);
        passwordInput.setFont(new Font("ARIAL", Font.PLAIN, 17));
        passwordInput.setBackground(new Color(9, 12, 20));
        passwordInput.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        passwordInput.setForeground(new Color(43, 47, 58));

        /*
            BUTTONS
        */

        loginButton.setBounds(90,325, 125, 35);
        loginButton.setFont(new Font("ARIAL", Font.BOLD, 17));
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(247, 147, 26));
        loginButton.setForeground(Color.white);
        loginButton.setBorder(null);

        /*
            ADDING
        */

        this.add(errorPanel);
        errorPanel.add(errorMessage);
        errorPanel.setVisible(false);
        errorMessage.setVisible(false);

        this.add(loginLabel);
        this.add(emailInputLabel);
        this.add(emailInput);
        this.add(passwordInputLabel);
        this.add(passwordInput);
        this.add(loginButton);
        this.add(dontHaveAnAccountLabel);

    }

}
