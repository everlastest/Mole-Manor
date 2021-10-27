package Singleton_LazyInitialization;

import Composite.Menu;
import Composite.MenuOption;
import SimpleFactory.Mole;
import SimpleFactory.MoleFactory;

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
        System.out.println("欢迎来到摩尔庄园！");
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

        /**
         * 设置菜单
         */
        Menu totalMenu=new Menu("分区选择");
        /**
         * 第一个分区游乐园为二级菜单
         */
        Menu amuseMenu=new Menu("游乐园");
        /**
         * 几个游戏
         */
        MenuOption Cooking=new MenuOption("Cooking",0);
        MenuOption Racing=new MenuOption("Racing",1);
        MenuOption Tictactoe=new MenuOption("Tictactoe",2);
        amuseMenu.add(Cooking);
        amuseMenu.add(Racing);
        amuseMenu.add(Tictactoe);
        /**
         * 其他选项
         */
        MenuOption a=new MenuOption("a",0);
        MenuOption b=new MenuOption("b",0);
        totalMenu.add(amuseMenu);
        totalMenu.add(a);
        totalMenu.add(b);
        /**
         * 菜单及返回
         */
        totalMenu.printMenu();
        int ch=input.nextInt();
        while(ch!=0){
            switch(ch){
                case 1:
                    System.out.println("欢迎来到游乐园！");
                    System.out.println("请选择想要玩的游戏：");
                    amuseMenu.printMenu();
                    break;
                case 2:
                    System.out.println("欢迎来到农场！");
                    break;
                case 3:
                    System.out.println("欢迎来到商场！");
                    break;
                default:
                    break;
            }
        }
        System.out.println("您即将离开摩尔庄园，再见是为了更好的重逢！");
    }

    //需要才创建，保证线程安全
    private static class SingletonHolder{
        private static MoleManor instance =new MoleManor();
    }
}
