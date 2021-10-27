package ChatRoom;

import RobotPackage.Robot;
import SimpleFactory.*;

public class ChatTestDemo {
    public static void main(String[] args) {

        MoleFactory mf = new MoleFactory();

        Mole me = mf.createMole("Kura", "Red");

        ChatUI myChatUI = new ChatUI(me);

        Robot r1 = new Robot("阿巴");
        Robot r2 = new Robot("呆瓜");

        r1.start();
        r2.start();

        myChatUI.chating();

        r1.stop();
        r2.stop();
    }

}
