package Gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPanel extends JPanel implements ActionListener {

    JTextField emailLoginInput;
    JTextField passwordLoginInput;

    public loginPanel() {

        this.setLayout(null);
        this.setBounds(0,0,400,290);
        this.setBackground(Color.pink);

        /*
            TEXT FIELDS
        */

        emailLoginInput = new JTextField();
        passwordLoginInput = new JTextField();

        emailLoginInput.setBounds(20,20,350,25);
        emailLoginInput.setFont(new Font("ARIAL", Font.PLAIN, 15));
        emailLoginInput.setText("Enter your email");

        /*
            ADDING
        */

        this.add(emailLoginInput);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
