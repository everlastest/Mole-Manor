package ChatRoom;

import Framework.SimpleFactory.Mole;
import Framework.SimpleFactory.MoleFactory;
import MoleAmuse.RobotPackage.Robot;

public class ChatTestDemo {
    public static void main(String[] args) {


        ChatUI myChatUI = new ChatUI();

        Robot r1 = new Robot("阿巴");
        Robot r2 = new Robot("呆瓜");

        r1.start();
        r2.start();

        myChatUI.chatting();

        r1.stop();
        r2.stop();
    }

}
