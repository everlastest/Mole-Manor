package MoleAmuse.GamePackage.RacingPackage.Template;

import Framework.SimpleFactory.Mole;
import Singleton_LazyInitialization.MoleManor;

import java.util.Scanner;

public abstract class AbstractRacing{

    private Mole mole = MoleManor.getPlayer();
    private int ticket;
    private int score;
    private int type;

    public AbstractRacing(int type) {
        this.type = type;
        this.ticket = mole.getTicket();
        this.score = 0;
    }

    public void score(int score){this.score = score;}


    /**
     * 检票
     */
    protected abstract boolean checkTicket(int ticket);


    /**
     * 准备阶段
     */
    public void Prepare(){
        System.out.println("\n请摩尔系好安全带，戴好头盔，游戏马上开始！！");
        System.out.println("输入1：确保安全带系好");
        Scanner input=new Scanner(System.in);
        while(input.nextInt()!=1){
            System.out.println("还未系好安全带，请重新输入");
        }
        System.out.println("输入2：确保头盔戴好");
        while(input.nextInt()!=2){
            System.out.println("还未戴好头盔，请重新输入");
        }
        System.out.println("输入3：游戏马上开始");
        while(input.nextInt()!=3){
            System.out.println("输入3：比赛开始！！！");
        }
    }

    /**
     * 不同赛车不同过程
     */
    protected abstract void RacingProcess(int score);

    /**
     * 获取得分
     */
    protected abstract int getScore(int score);

    /**
     * 整个过程模板
     */
    public void StartRacing(){

        if(checkTicket(ticket)==false) {
            System.out.println("\n正在返回摩摩赛车城...\n");
            return;
        }

        mole.setTicket(ticket - 1);

        Prepare();

        RacingProcess(score);

        mole.setScore(mole.getScore() + getScore(score));
        System.out.println("小摩尔此次获得游戏积分：" + getScore(score) + ", 总积分为：" + mole.getScore());

        System.out.println("正在返回摩摩赛车城...\n");
    }

}