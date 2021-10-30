package Framework.Blackboard;

import Singleton_LazyInitialization.MoleManor;

public class BlackboardUI {
    /**
     * 显示公告内容
     */
    public void showBlackboard(){

        Blackboard blackboard = new Blackboard();

        Control control = new Control(blackboard);
        control.addNotice("游乐园的小游戏欢迎大家来玩哟！");
        control.addNotice("今天的商场又搞促销啦！");
        control.addAllNotice();

        blackboard.show();
        System.out.println();
    }
}