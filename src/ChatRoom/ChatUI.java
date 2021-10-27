package ChatRoom;

import SimpleFactory.Mole;

import java.util.Scanner;

//中介者模式：聊天界面
public class ChatUI {

    //添加角色和聊天室
    private Mole mole;
    private Chatroom chatroom = Chatroom.getInstance();

    public ChatUI(Mole mole){
        this.mole = mole;
    }

    //发送消息
    private void sendMessage(String message){
        chatroom.addMessage(mole.getMoleName(), message);
    }

    private void showMessage(){
        chatroom.showMessage();
    }

    //聊天界面接口
    public void chating(){
        System.out.println("\n进入聊天室:\n发送信息亲——请输入”1“+”信息“\n显示聊天室信息——请输入“2“\n退出聊天室请输入——”0“\n");
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
                    System.out.println("已退出聊天室！");
                    return;
                default:
                    break;
            }
        }
    }

}
