package MoleAmuse.GamePackage.RacingPackage.Template;

public abstract class AbstractRacing{
    private int ticket;
    private int score;
    private int type;

    public AbstractRacing(int type){this.type=type;}
    public void score(int score){this.score=score;}

    public void getTicketInfo(int ticket){
        this.ticket=ticket;
        this.score=0;
    }

    /**
     * 检票
     */
    protected abstract boolean checkTicket(int ticket);


    /**
     * 准备阶段
     */
    public void Prepare(){
        System.out.println("请摩尔系好安全带，戴好头盔，游戏马上开始！！");
        System.out.println("输入1：确保安全带系好，输入2：确保头盔戴好，输入s：比赛开始！！");
    }

    /**
     * 不同赛车不同过程
     */
    protected abstract void RacingProcess(int score);

    /**
     * 获取得分
     */
    protected abstract void getScore(int score);

    /**
     * 整个过程模板
     */
    public void StartRacing(){

        if(checkTicket(ticket)==false) return;
        Prepare();
        RacingProcess(score);
        getScore(score);
    }

}