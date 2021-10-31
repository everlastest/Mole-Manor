package chatroom.mutex;

import chatroom.Chatroom;
import chatroom.robotpackage.Robot;

import java.util.Scanner;

public class MutexTestDemo {
    public static void main(String[] args) {
        Robot r1 = new Robot("r1");
        Robot r2 = new Robot("r2");
        r1.start();
        r2.start();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            Chatroom.getInstance().showMessage();
        }
    }
}
