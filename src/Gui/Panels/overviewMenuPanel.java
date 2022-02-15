package Gui.Panels;

import Program.userAPI;

import javax.swing.*;
import java.awt.*;

public class overviewMenuPanel extends JPanel {

    userAPI user = new userAPI();

    /*
        PUBLIC LABELS
    */

    public overviewMenuPanel() {

        this.setLayout(null);
        this.setBounds(190,0,485,500);
        this.setBackground(new Color(20, 24, 34));

    }

}
