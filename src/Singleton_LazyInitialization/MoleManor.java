package Singleton_LazyInitialization;

import Framework.Composite.Menu;
import Framework.Composite.MenuOption;
import Framework.SimpleFactory.Mole;
import Framework.SimpleFactory.MoleFactory;
import MoleAmuse.ChatRoom.ChatUI;
import MoleAmuse.GamePackage.GameMaker;
import MoleAmuse.RobotPackage.Robot;


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
        Scanner input=new Scanner(System.in);
        //创建角色
        System.out.println("请输入你的名字：");
        String name=input.nextLine();
        System.out.println("选择你的角色：[1]Molele [2]Momo [3]Kura");
        int roleNum=input.nextInt();
        System.out.println("选择外观颜色：[1]Red [2]Green [3]Blue");
        int colorNum=input.nextInt();
        String role="Molele";
        String color="Red";
        switch(roleNum){
            case 1:
                role="Molele";
                break;
            case 2:
                role="Momo";
                break;
            case 3:
                role="Krua";
                break;
            default:
                break;
        }
        switch(colorNum){
            case 1:
                color="Red";
                break;
            case 2:
                color="Green";
                break;
            case 3:
                color="Blue";
                break;
            default:
                break;
        }
        MoleFactory moleFactory=new MoleFactory();
        player=moleFactory.createMole(role,color);
        player.setMoleName(name);

        //设置菜单
        Menu totalMenu=new Menu("分区选择");

        //第一个分区游乐园为二级菜单
        Menu amuseMenu=new Menu("游乐园");

        //几个游戏
        MenuOption Cooking=new MenuOption("做菜",0);
        MenuOption Racing=new MenuOption("摩摩赛车",1);
        MenuOption Tictactoe=new MenuOption("井字棋",2);
        amuseMenu.add(Cooking);
        amuseMenu.add(Racing);
        amuseMenu.add(Tictactoe);
        /**
         * 其他选项
         */
        MenuOption farmMenu=new MenuOption("农场",0);
        MenuOption mallMenu=new MenuOption("商场",0);
        MenuOption chat=new MenuOption("聊天室",0);
        totalMenu.add(amuseMenu);
        totalMenu.add(farmMenu);
        totalMenu.add(mallMenu);
        totalMenu.add(chat);
        //菜单及返回
        totalMenu.printMenu();
        int ch=input.nextInt();
        while(ch!=0){
            switch(ch){
                case 1:
                    System.out.println("欢迎来到游乐园！");
                    System.out.println("请选择想要玩的游戏：");
                    amuseMenu.printMenu();
                    GameMaker gameMaker=new GameMaker();
                    switch(input.nextInt()){
                        case 1:
                            gameMaker.playCooking();
                            break;
                        case 2:
                            gameMaker.playRacing();
                            break;
                        case 3:
                            gameMaker.playTictactoe();
                            break;
                        case 0:
                            Cooking.getLast().printMenu();
                            ch = input.nextInt();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("欢迎来到农场！");
                    break;
                case 3:
                    System.out.println("欢迎来到商场！");
                    break;
                case 4:
                    System.out.println("欢迎来到聊天室！");
                    ChatUI myChatUI = new ChatUI(player);
                    Robot r1 = new Robot("阿巴");
                    Robot r2 = new Robot("呆瓜");
                    r1.start();
                    r2.start();
                    myChatUI.chating();
                    r1.stop();
                    r2.stop();
                    break;
                default:
                    break;
            }
        }
        System.out.println("即将离开摩尔庄园，再见是为了更好的重逢！");
    }

    public Mole getPlayer() {
        return player;
    }
    //需要才创建，保证线程安全
    private static class SingletonHolder{
        private static MoleManor instance =new MoleManor();
    }
}
