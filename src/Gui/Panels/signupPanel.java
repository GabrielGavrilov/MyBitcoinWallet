package Gui.Panels;

import javax.swing.*;
import java.awt.*;

public class signupPanel extends JPanel {

    public static JTextField userEmailInput = new JTextField();
    public static JTextField userPasswordInput = new JTextField();
    public static JTextField userPasswordConfirmation = new JTextField();

    public signupPanel() {

        this.setLayout(null);
        this.setBounds(0, 45, 400, 100);

        /*
            TEXT FIELDS
        */

        userEmailInput.setBounds(15, 5, 363, 22);
        userEmailInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        userEmailInput.setText("Enter your email");

        userPasswordInput.setBounds(15, 35, 363, 22);
        userPasswordInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        userPasswordInput.setText("Choose a strong password");

        userPasswordConfirmation.setBounds(15, 65, 363, 22);
        userPasswordConfirmation.setFont(new Font("ARIAL", Font.PLAIN, 15));
        userPasswordConfirmation.setText("Confirm password");

        /*
            ADDING
        */

        this.add(userEmailInput);
        this.add(userPasswordInput);
        this.add(userPasswordConfirmation);

    }

}
