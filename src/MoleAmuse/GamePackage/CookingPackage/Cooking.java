package MoleAmuse.GamePackage.CookingPackage;

import Framework.SimpleFactory.Mole;
import MoleAmuse.GamePackage.CookingPackage.Prototype.AbstractMeal;
import MoleAmuse.GamePackage.Game;
import MoleAmuse.GamePackage.MementoPackage.*;
import Singleton_LazyInitialization.MoleManor;

import java.util.Scanner;

public class Cooking implements Game {

    private Mole mole = MoleManor.getPlayer();

    @Override
    public void Play() {
        System.out.println("\n进入摩尔厨房!");
        Scanner input = new Scanner(System.in);

        int index = 0;

        MealCache.loadCache();

        while(true){
            System.out.println("请输入你想做的菜：[1]宫保鸡丁 [2]糖醋里脊 [3]酸菜鱼");

            String type = input.nextLine();
            AbstractMeal clonedmeal = (AbstractMeal) MealCache.getMeal(type);
            clonedmeal.cook();

            System.out.println("是否拿走奖励，离开厨房？[Y/N]");
            if(input.next() == "Y") break;
        }

        mole.setScore(mole.getScore() + index);
        System.out.println("小摩尔"+MoleManor.getPlayer().getMoleName()+"此次获得游戏积分：" + index + ", 总积分为：" + mole.getScore());

        mole.setMoney(mole.getMoney() + 100 * index);
        System.out.println("小摩尔"+MoleManor.getPlayer().getMoleName()+"此次获得摩尔豆：" + 100 * index + ", 总摩尔豆为：" + mole.getMoney());

        /**
         * 添加备忘录
         */
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(1,"摩摩厨房");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());

        System.out.println("\n正在退出摩尔厨房......\n成功退出，已返回游乐园！\n");
    }
}
