package MoleAmuse.GamePackage.MementoPackage;

/**
 * @author 罗检
 *
 * 存储玩过的游戏名称与分数
 */
public class RecordMemento {
    private int score;
    private String game_name;

    public RecordMemento(int score, String game_name){
        this.score = score;
        this.game_name = game_name;
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
     * @return game_name
     */
    public String getName(){
        return game_name;
    }
}
