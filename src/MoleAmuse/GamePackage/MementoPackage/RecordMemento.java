package MoleAmuse.GamePackage.MementoPackage;

/**
 * @author 罗检
 *
 * 存储玩过的游戏名称与分数
 */
public class RecordMemento {
    private int score;
    private String gameName;

    public RecordMemento(int score, String gameName){
        this.score = score;
        this.gameName = gameName;
    }
    /**
     * 获取分数
     * @return score
     */
    public int getScore(){
        return score;
    }
    /**
     * 获取游戏名称
     * @return gameName
     */
    public String getName(){
        return gameName;
    }
}
