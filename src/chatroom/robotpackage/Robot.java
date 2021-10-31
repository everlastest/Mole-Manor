package chatroom.robotpackage;

import chatroom.Chatroom;

import java.util.Random;

/**
 * 聊天机器人
 */
public class Robot implements Runnable {

    //终止线程标识符
    public volatile boolean exit = false;

    private Thread t;

    //线程名字
    private String RobotName;

    private Chatroom chatroom = Chatroom.getInstance();

    private String[] randMessage = {"", "今天天气不错", "中午吃什么", "我要去游乐园","你好呀"};
    private Random random = new Random();


    public Robot(String name) {
        RobotName = name;
        randMessage[0] = "我是" + name;
    }

    private String BuildMessage(){
        int r = random.nextInt(4);
        return randMessage[r];
    }

    private void sendMessage(String message){
        chatroom.addMessage(RobotName, message);
    }



    /**
     * 线程操作：向聊天室添加消息
     */
    public void run() {

        try {
            while (exit) {

                String str = BuildMessage();

                //获取线程锁
                chatroom.Lock();
                //发送信息
                try {
                    sendMessage(str);
                } finally {
                    chatroom.unLock();//解锁
                }

                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  RobotName + " interrupted.");
        }


    }


    /**
     * 启动线程
     */
    public void start () {

        if (t == null) {
            t = new Thread (this, RobotName);
            t.start ();
            exit = true;
        }

    }

    public void stop() {exit = false;}
}
