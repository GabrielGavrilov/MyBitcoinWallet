package Gui.Panels;

import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class signupPanel extends JPanel {

    /*
        PUBLIC PANELS
    */

    public JPanel errorPanel = new JPanel();

    /*
        PUBLIC LABELS
    */

    public JLabel errorMessage = new JLabel();
    public JLabel signupLabel = new JLabel();
    public JLabel emailInputLabel = new JLabel();
    public JLabel passwordInputLabel = new JLabel();
    public JLabel confirmPasswordInputLabel = new JLabel();
    public JLabel haveAnAccountLabel = new JLabel();

    /*
       PUBLIC TEXT FIELDS
    */

    public static JTextField emailInput = new JTextField();
    public static JPasswordField passwordInput = new JPasswordField();
    public static JPasswordField confirmPasswordInput = new JPasswordField();

    /*
       PUBLIC BUTTONS
    */

    public static JButton signupButton = new JButton("Sign Up");

    public signupPanel() {

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

        signupLabel.setText("Sign Up");
        signupLabel.setFont(new Font("ARIAL", Font.BOLD, 25));
        signupLabel.setBounds(105, 25, 300, 27);
        signupLabel.setForeground(Color.white);

        emailInputLabel.setText("Enter your email:");
        emailInputLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        emailInputLabel.setForeground(new Color(126, 133, 143));
        emailInputLabel.setBounds(10, 78, 250, 20);

        passwordInputLabel.setText("Choose a strong password:");
        passwordInputLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        passwordInputLabel.setForeground(new Color(126,133,143));
        passwordInputLabel.setBounds(10, 143, 250, 20);

        confirmPasswordInputLabel.setText("Confirm password:");
        confirmPasswordInputLabel.setFont(new Font("ARIAL", Font.PLAIN, 16));
        confirmPasswordInputLabel.setForeground(new Color(126,133,143));
        confirmPasswordInputLabel.setBounds(10, 208, 250, 20);

        haveAnAccountLabel.setText("have an account?");
        haveAnAccountLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
        haveAnAccountLabel.setForeground(new Color(126,133,143));
        haveAnAccountLabel.setBounds(82, 275, 200, 20);

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

        confirmPasswordInput.setBounds(10, 230, 278, 27);
        confirmPasswordInput.setFont(new Font("ARIAL", Font.PLAIN, 17));
        confirmPasswordInput.setBackground(new Color(9, 12, 20));
        confirmPasswordInput.setBorder(new LineBorder(new Color(43, 47, 58), 1));
        confirmPasswordInput.setForeground(new Color(43, 47, 58));

        /*
            BUTTONS
        */

        signupButton.setBounds(90,325, 125, 35);
        signupButton.setFont(new Font("ARIAL", Font.BOLD, 17));
        signupButton.setFocusable(false);
        signupButton.setBackground(new Color(247, 147, 26));
        signupButton.setForeground(Color.white);
        signupButton.setBorder(null);

        /*
            ADDING
        */

        this.add(errorPanel);
        errorPanel.add(errorMessage);
        errorPanel.setVisible(false);
        errorMessage.setVisible(false);

        this.add(signupLabel);
        this.add(emailInputLabel);
        this.add(emailInput);
        this.add(passwordInputLabel);
        this.add(passwordInput);
        this.add(confirmPasswordInputLabel);
        this.add(confirmPasswordInput);
        this.add(signupButton);
        this.add(haveAnAccountLabel);

    }

}
