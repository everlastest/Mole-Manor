package chatroom.mutex;

import chatroom.Chatroom;
import chatroom.robotpackage.NPCList;

import java.util.Scanner;

public class MutexTestDemo {
    public static void main(String[] args) {

        NPCList.getInstance().start();

        while (true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            Chatroom.getInstance().showMessage();
        }
    }
}
