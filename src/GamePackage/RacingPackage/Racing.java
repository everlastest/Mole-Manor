package GamePackage.RacingPackage;

import GamePackage.Game;
import GamePackage.RacingPackage.Template.AbstractRacing;
import GamePackage.RacingPackage.Template.DriftRace;
import GamePackage.RacingPackage.Template.ObstacleRace;
import GamePackage.RacingPackage.Template.TimeRace;

import java.util.Scanner;

public class Racing implements Game{
    @Override
    public void Play() {
        System.out.println("欢迎来到摩摩赛车城，请选择你要进行的项目：");
        System.out.println("1.竞速赛");
        System.out.println("2.漂移赛");
        System.out.println("3.障碍赛");
        AbstractRacing abstractRacing = null;
        int racingType = 0;
        Scanner scan = new Scanner(System.in);
        while (racingType == 0) {
            switch (scan.nextInt()) {
                case 1:
                    racingType = 1;
                    System.out.println("你已选择竞速赛！");
                    abstractRacing = new TimeRace();
                    break;
                case 2:
                    racingType = 2;
                    System.out.println("你已选择漂移赛！");
                    abstractRacing = new DriftRace();
                    break;
                case 3:
                    racingType = 3;
                    System.out.println("你已选择障碍赛！");
                    abstractRacing = new ObstacleRace();
                    break;
                default:
                    System.out.println("输入错误，请重新选择：");
                    break;
            }
        }
        abstractRacing.getTicketInfo(1);
        abstractRacing.StartRacing();
    }
}
