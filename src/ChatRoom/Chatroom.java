package ChatRoom;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

//中介者模式：聊天室
public class Chatroom {

    //单例
    private static Chatroom instance = new Chatroom();
    private Chatroom(){}
    public static Chatroom getInstance(){
        return instance;
    }

    //消息锁
    public ReentrantLock lock = new ReentrantLock();

    //消息队列
    private LinkedList<String> MessageList = new LinkedList<String>();

    //添加消息
    public void addMessage(String username, String message){
        MessageList.addLast(new Date().toString()
                + " [" + username +"] : " + message);

        //队列中只支持30条消息
        if(MessageList.size() > 30){
            MessageList.removeFirst();
        }
    }

    //显示消息
    public void showMessage(){

        Iterator<String> it = MessageList.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
