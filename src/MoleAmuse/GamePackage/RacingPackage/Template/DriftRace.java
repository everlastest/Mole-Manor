package MoleAmuse.GamePackage.RacingPackage.Template;

import java.util.Random;

/**
 * 漂移赛车
 */
public class DriftRace extends AbstractRacing{

    public DriftRace(){
        super(2);
    }

    @Override
    protected boolean checkTicket(int ticket){
        System.out.println("正在检票......");
        if(ticket==0) {
            System.out.println("票数不足，无法参加漂移赛，请先购买票！！");
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
        System.out.println("漂移赛正式开始！！");
        Random random=new Random();
        int r=0;
        for(int i=0;i<10;i++) {

            try {
                System.out.println("小摩尔进入弯道！！");
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            r = random.nextInt(3) % 2;
            if (r == 0) {
                Score++;
                score(Score);
                System.out.println("小摩尔成功完成一次漂移！！");
            } else
                System.out.println("小摩尔此次漂移失败，再接再厉！！");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void getScore(int Score) {
        System.out.println("小摩尔完成此次漂移赛");
        System.out.println("小摩尔的最终的分为："+Score+"（满分10分）");
        System.out.println("再接再厉！！");
    }
}
