package MoleAmuse.GamePackage.RacingPackage.Template;

import java.util.Random;

/**
 * 障碍赛
 */
public class ObstacleRace extends AbstractRacing{

    public ObstacleRace(){
        super(3);
    }
    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加障碍赛，请先购买票！！");
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
        for(int i=0;i<7;i++) {
            try {
                System.out.println("小摩尔来到第"+(i+1)+"关......");
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r= random.nextInt(15);
            if(r>(i+1)) {
                System.out.println("小摩尔成功通过第" + (i + 1) + "关!!");
                Score++;
                score(Score);
            }else{
                System.out.println("小摩尔在第" + (i + 1) + "关失误，胜败乃兵家常事，摩尔请从新来过！！");
                break;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void getScore(int Score) {
        if(Score==7){
            System.out.println("小摩尔成功通过障碍赛！！");
            System.out.println("小摩尔的最终的成绩为："+Score+"（满分为7分）");
            System.out.println("请收下膝盖！！");
            System.out.println("正在退出赛车游戏......\n成功退出，已返回游乐园！！！\n");
        }else{
            System.out.println("小摩尔止遗憾步障碍赛第"+ (Score + 1) + "关!!");
            System.out.println("最终的成绩为："+Score+"（满分为7分）");
            System.out.println("再接再厉！！");
            System.out.println("正在退出赛车游戏......\n成功离开，已返回游乐园！！！\n");
        }
    }
}
