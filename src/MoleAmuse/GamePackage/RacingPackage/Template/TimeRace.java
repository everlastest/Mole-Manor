package MoleAmuse.GamePackage.RacingPackage.Template;

import java.util.Random;

/**
 * 竞速赛车
 */
public class TimeRace extends AbstractRacing{

    public TimeRace(){
        super(1);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加竞速赛，请先购买票！！");
            return false;
        }
        else{
            ticket--;
            System.out.println("检票成功！！");
            return true;
        }
    }

    @Override
    protected void RacingProcess(int Score) {
        Random random=new Random();
        int r=0;
        for(int i=0;i<5;i++) {
            r= random.nextInt(10)+10;
            try {
                System.out.println("小摩尔正在进行第"+(i+1)+"圈......");
                Thread.sleep(200*(r));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小摩尔完成第"+(i+1)+"圈，"+"用时"+r*6+"秒!!");
            Score+=r*6;
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            score(Score);
        }
    }

    @Override
    protected void getScore(int Score) {
        if(Score<540){
        System.out.println("小摩尔在规定的时间内成功完成比赛！！");
        System.out.println("小摩尔的最终的成绩为："+Score+"秒");
        System.out.println("再接再厉！！");
        System.out.println("正在退出赛车游戏......\n成功离开，已返回游乐园！！！\n");
        }
        else{
        System.out.println("小摩尔在规定的时间内未完成比赛！！");
        System.out.println("成绩无效，再接再厉！！");
        System.out.println("正在退出赛车游戏......\n成功离开，已返回游乐园！！！\n");
        }
    }
}
