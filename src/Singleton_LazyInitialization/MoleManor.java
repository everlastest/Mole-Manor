package Singleton_LazyInitialization;

import Framework.Composite.*;
import Framework.SimpleFactory.*;
import MoleAmuse.RobotPackage.*;
import ChatRoom.*;
import MoleAmuse.GamePackage.*;

import java.util.Scanner;


public class MoleManor {
    //创建一个MoleManor的一个对象
    private Mole player;

    /**
     * 天气情况
     */
    String[] weathers={"晴天","雨天","阴天"};
    String weather=weathers[(int)(Math.random()*3)];

    //构造函数为private，该类不会被实例化
    private MoleManor(){
    }
    public static MoleManor getInstance(){return SingletonHolder.instance;}

    //输出测试信息
    public void showMessage(){
        System.out.println("MoleManor is created successfully!");
    }

    //整个流程
    public void flowController() throws CloneNotSupportedException{
        System.out.println("欢迎来到摩尔庄园！\n\n\n");
        Scanner input = new Scanner(System.in);

        /**
         * 创建角色
         */
        MoleCreator moleCreator = MoleCreator.getInstance();
        player = moleCreator.createMole();
        System.out.println("\n角色创建成功，正在进入摩尔大厅！！！\n\n\n");

        /**
         * 添加聊天机器人
         */
        RobotList robotList = RobotList.getInstance();
        robotList.addRobot("菩提大伯", "么么公主", "瑞琪");

        /**
         * 主菜单
         */
        MenuList menuList = MenuList.getInstance();
        Component totalMenu = menuList.getMenulist("摩尔大厅");
        totalMenu.printMenu();

        while(true){

            switch(input.nextInt()){
                case 1:
                    System.out.println("\n欢迎来到摩尔游乐园！\n请选择想要玩的游戏：");
                    GameUI gamemaker=new GameUI(player);
                    gamemaker.playGame();
                    break;
                case 2:
                    System.out.println("欢迎来到摩尔农场！\n");
                    break;
                case 3:
                    System.out.println("欢迎来到摩尔商场！\n");
                    break;
                case 4:
                    System.out.println("正在进入摩尔聊天室！\n");
                    ChatUI chatroom = new ChatUI(player);
                    chatroom.chating();
                    break;
                case 0:
                    System.out.println("\n您即将离开摩尔庄园，再见是为了更好的重逢！");
                    robotList.stop();
                    return;
                default:
                    break;
            }

            totalMenu.printMenu();
        }
    }

    public Mole getPlayer() {
        return player;
    }
    //需要才创建，保证线程安全
    private static class SingletonHolder{
        private static MoleManor instance =new MoleManor();
    }
}
