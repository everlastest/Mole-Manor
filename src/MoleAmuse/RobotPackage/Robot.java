package MoleAmuse.RobotPackage;

import MoleAmuse.ChatRoom.Chatroom;

import java.util.Random;

//机器人，可以聊天
public class Robot implements Runnable {

    public volatile boolean exit = false;

    private Thread t;
    private String RobotName;
    private Chatroom chatroom = Chatroom.getInstance();
    private String[] randMessage = {"", "今天天气不错", "中午吃什么", "我要去游乐园","你好呀"};
    private Random random = new Random();

    private void sendMessage(String message){
        chatroom.addMessage(RobotName, message);
    }

    public Robot(String name) {
        RobotName = name;
        randMessage[0] = "我是" + name;
    }

    private String BuildMessage(){
        int r = random.nextInt(4);
        return randMessage[r];
    }


    public void run() {

        try {
            while (exit) {

                String str = BuildMessage();
                chatroom.lock.lock();
                try {
                    sendMessage(str);
                } finally {
                    chatroom.lock.unlock();
                }

                Thread.sleep(10000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  RobotName + " interrupted.");
        }


    }


    //开启线程
    public void start () {

        if (t == null) {
            t = new Thread (this, RobotName);
            t.start ();
            exit = true;
        }

    }

    public void stop() {

        exit = false;

    }
}
