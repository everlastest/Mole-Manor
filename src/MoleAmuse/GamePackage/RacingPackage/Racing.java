package MoleAmuse.GamePackage.RacingPackage;

import Framework.Composite.Component;
import Framework.Composite.MenuList;
import MoleAmuse.GamePackage.Game;
import MoleAmuse.GamePackage.RacingPackage.Template.AbstractRacing;
import MoleAmuse.GamePackage.RacingPackage.Template.DriftRace;
import MoleAmuse.GamePackage.RacingPackage.Template.ObstacleRace;
import MoleAmuse.GamePackage.RacingPackage.Template.TimeRace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Racing implements Game{
    @Override
    public void Play() {

        MenuList menuList = MenuList.getInstance();
        Component raceMenu = menuList.getMenulist("摩摩赛车场");

        AbstractRacing abstractRacing = null;
        int racingType = 0;
        //打印菜单
        raceMenu.printMenu();

        int s=-1;
        while (s == -1) {

            /**
             * 异常处理
             */
            try {
                Scanner scan = new Scanner(System.in);
                s = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Exception thrown  :" + e);
                System.out.println("输入错误，应输入数字！！");
            }

            switch (s) {
                case 1:
                    racingType = 1;
                    System.out.println("\n正在启动摩摩竞速赛！");
                    abstractRacing = new TimeRace();
                    break;
                case 2:
                    racingType = 2;
                    System.out.println("\n正在启动摩摩漂移赛！");
                    abstractRacing = new DriftRace();
                    break;
                case 3:
                    racingType = 3;
                    System.out.println("\n正在启动摩摩障碍赛！");
                    abstractRacing = new ObstacleRace();
                    break;
                case 0:
                    System.out.println("\n" + "正在退出摩摩赛车场......\n成功离开，已返回游乐园！\n");
                    return;
                default:
                    System.out.println("输入错误，请重新输入！！");
                    s = -1;
                    break;
            }
        }
        abstractRacing.StartRacing();
        racingType = 0;
    }
}
