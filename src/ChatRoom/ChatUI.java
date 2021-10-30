package ChatRoom;

import Framework.Composite.*;
import Framework.SimpleFactory.Mole;
import Singleton_LazyInitialization.MoleManor;

import java.util.Scanner;

//中介者模式：聊天界面
public class ChatUI {

    //添加角色和聊天室
    private Mole mole = MoleManor.getPlayer();
    private Chatroom chatroom = Chatroom.getInstance();

    public ChatUI(){}

    //发送消息
    private void sendMessage(String message){
        chatroom.addMessage(mole.getMoleName(), message);
    }

    private void showMessage(){
        chatroom.showMessage();
    }


    //聊天界面接口
    public void chating(){

        MoleManor.printMenu();

        while (true){

            Scanner scan = new Scanner(System.in);

            switch (scan.nextInt()) {
                case 1:
                    String message = null;
                    if (scan.hasNext()) {
                        message = scan.next();
                    }

                    chatroom.lock.lock();
                    try {
                        sendMessage(message);
                    } finally {
                        chatroom.lock.unlock();
                    }
                    break;
                case 2:
                    showMessage();
                    break;
                case 0:
                    System.out.println("已退出聊天室，即将返回摩尔大厅！！！\n\n");
                    return;
                default:
                    break;
            }
        }
    }

}
