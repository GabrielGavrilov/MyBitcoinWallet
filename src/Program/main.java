package Program;

import Gui.Frames.loginFrame;
import Gui.Frames.walletFrame;

public class main {
    public static void main(String[] args) throws InterruptedException {

        boolean developerMode;
        developerMode = false;

        System.out.println("Starting app.");

        if(developerMode == false) {

            loginFrame login = new loginFrame();

        } else if(developerMode == true) {

           walletFrame wallet = new walletFrame();

        }

    }

}
