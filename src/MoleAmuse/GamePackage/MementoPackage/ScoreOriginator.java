package MoleAmuse.GamePackage.MementoPackage;

/**
 * @author 罗检
 *
 * 游戏名称与分数信息并存储到mememto中
 */
public class ScoreOriginator {
    private int score;
    private String game_name;
    /**
     * 记录当前游戏名称与分数
     * @param score 得分
     * @param game_name 游戏名称
     */
    public void setRecord(int score, String game_name){
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
    /**
     * 将当前记录存储到RecordMemento中
     * @return RecordMemento
     */
    public RecordMemento saveRecordToMemento(){
        return new RecordMemento(score,game_name);
    }

}

