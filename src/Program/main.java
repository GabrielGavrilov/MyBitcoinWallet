package Program;

import Gui.Frames.walletFrame;

public class main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting app.");
        //walletFrame wallet = new walletFrame();

        mongoDatabase database = new mongoDatabase();
        database.insertNewUser("gabrielgavrilov11@gmail.com", "winter22");

        System.out.println("User created.");

    }

}
