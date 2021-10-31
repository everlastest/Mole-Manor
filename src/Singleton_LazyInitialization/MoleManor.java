package Singleton_LazyInitialization;

import Framework.Blackboard.BlackboardUI;
import Framework.Composite.*;
import Framework.SimpleFactory.*;
import ChatRoom.RobotPackage.*;
import ChatRoom.*;
import MoleAmuse.GamePackage.*;
import moleFarm.FarmProcess;

import java.util.Scanner;


public class MoleManor {
    //创建一个MoleManor的一个静态对象
    private static Mole player;

    //菜单
    private static Component currentMenu;

    /**
     * 天气情况
     */
    String[] weathers={"晴天","雨天","阴天"};
    String weather=weathers[(int)(Math.random()*3)];

    //构造函数为private，该类不会被实例化
    private MoleManor(){
    }
    public static MoleManor getInstance(){return SingletonHolder.instance;}

    /**
     * 测试用例！！！！
     * 不使用该函数！！！！
     */
    public void test() {
        MoleFactory moleFactory = new MoleFactory();
        player = moleFactory.createMole("Momo","Red");
        player.setMoleName("test");
        player.setMoney(1000);
        player.setTicket(2);
        player.setScore(0);
    }


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
        player = MoleCreator.getInstance().createMole();
        System.out.println("\n角色创建成功，正在进入摩尔大厅！！！\n\n\n");

        /**
         * 添加聊天机器人
         */

        RobotList.getInstance().addRobot("菩提大伯", "么么公主", "瑞琪");

        /**
         * 主菜单
         */
        currentMenu = MenuList.getInstance().meanMenu();
        BlackboardUI blackboard = new BlackboardUI();
        blackboard.showBlackboard();

        while(true){

            printMenu();

            int i = input.nextInt();

            moveTo(i - 1);

            switch(i){
                case 1:
                    System.out.println("\n正在进入摩尔游乐园！");
                    GameUI gamemaker = new GameUI();
                    gamemaker.playGame();
                    break;
                case 2:
                    System.out.println("欢迎来到摩尔农场！\n");
                    FarmProcess farmProcess = FarmProcess.newInstance();
                    farmProcess.process();
                    break;
                case 3:
                    System.out.println("欢迎来到摩尔商场！\n");
                    break;
                case 4:
                    System.out.println("\n正在进入摩尔聊天室！");
                    ChatUI chatroom = new ChatUI();
                    chatroom.chatting();
                    break;
                case 5:
                    System.out.println("\n正在显示广告牌内容！");
                    blackboard.showBlackboard();
                    break;
                case 0:
                    goback();
                    System.out.println("\n您即将离开摩尔庄园，再见是为了更好的重逢！");
                    RobotList.getInstance().stop();
                    return;
                default:
                    break;
            }

            goback();

        }
    }

    public static Mole getPlayer() {
        return player;
    }
    //需要才创建，保证线程安全
    private static class SingletonHolder{
        private static MoleManor instance =new MoleManor();
    }

    /**
     * 菜单切换，打印操作
     * @param index
     */
    public static void moveTo(int index){
        currentMenu = currentMenu.moveTo(index);
    }

    public static void goback(){
        currentMenu = currentMenu.getLast();
    }

    public static void printMenu(){
        currentMenu.printMenu();
    }

}
