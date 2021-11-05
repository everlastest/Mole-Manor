package chatroom.test;

import chatroom.Chatroom;
import chatroom.robotpackage.NPCList;

import java.util.Scanner;

public class MutexTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用互斥模式ing----");

        NPCList.getInstance().start();

        System.out.println("是否查看聊天室信息？[1/0]");
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        while (flag == 1){
            Chatroom.getInstance().showMessage();
            flag = scanner.nextInt();
        }

        NPCList.getInstance().stop();
    }

    public static void main(String[] args) {
        MutexTest.test();
    }
}
