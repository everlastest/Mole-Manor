package MoleAmuse.GamePackage.CookingPackage;

import Framework.SimpleFactory.Mole;
import MoleAmuse.GamePackage.Game;
import Singleton_LazyInitialization.MoleManor;

import java.util.Scanner;

public class Cooking implements Game {

    private Mole mole = MoleManor.getPlayer();
    @Override
    public void Play() {
        System.out.println("\n启动摩尔厨房，请输入你想做的菜：");
        Scanner input=new Scanner(System.in);
        String cook=input.nextLine();
        try{
            System.out.println("\n准备材料中...");
            Thread.sleep(1500);
            System.out.println("做饭中...\n");
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(cook+"已做好");

        mole.setScore(mole.getScore() + 1);
        System.out.println("小摩尔此次获得游戏积分：" + 1 + ", 总积分为：" + mole.getScore());

        mole.setMoney(mole.getMoney() + 100);
        System.out.println("小摩尔此次获得摩尔豆：" + 100 + ", 总摩尔豆为：" + mole.getMoney());

        System.out.println("\n正在退出摩尔厨房......\n成功退出，已返回游乐园！\n");
    }
}
