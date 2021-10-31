package MoleAmuse.RacingPackage;

import ExceptionHandle.ExceptionHandle;
import MoleAmuse.Game;
import MoleAmuse.RacingPackage.Template.*;
import MoleAmuse.RacingPackage.Template.AbstractRacing;
import MoleAmuse.RacingPackage.Template.DriftRace;
import MoleAmuse.RacingPackage.Template.ObstacleRace;
import MoleAmuse.RacingPackage.Template.TimeRace;
import Singleton_LazyInitialization.MoleManor;

public class Racing implements Game {
    @Override
    public void Play() {

        AbstractRacing abstractRacing = null;
        int racingType = 0;

        //用于异常处理
        ExceptionHandle exceptionHandle=new ExceptionHandle();

        while (racingType == 0) {

            MoleManor.printMenu();

            racingType=exceptionHandle.exception();

            switch (racingType) {
                case 1:
                    System.out.println("\n正在启动摩摩竞速赛！");
                    abstractRacing = new TimeRace();
                    abstractRacing.StartRacing();
                    racingType = 0;
                    break;
                case 2:
                    System.out.println("\n正在启动摩摩漂移赛！");
                    abstractRacing = new DriftRace();
                    abstractRacing.StartRacing();
                    racingType = 0;
                    break;
                case 3:
                    System.out.println("\n正在启动摩摩障碍赛！");
                    abstractRacing = new ObstacleRace();
                    abstractRacing.StartRacing();
                    racingType = 0;
                    break;
                case 0:
                    System.out.println("\n" + "正在退出摩摩赛车场......\n成功离开，已返回游乐园！\n");
                    return;
                default:
                    System.out.println("输入错误，请重新输入！！");
                    racingType = 0;
                    break;
            }
        }
    }
}
