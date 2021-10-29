package MoleAmuse.GamePackage.MementoPackage;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 罗检
 *
 * 恢复游玩过的游戏名称与分数
 */
public class RecordList {
    private List<RecordMemento> recordList = new ArrayList<RecordMemento>();
    /**
     * 添加游戏记录
     * @param record 游戏记录
     */
    public void add(RecordMemento record){
        recordList.add(record);
    }
    /**
     * 获取某一游戏记录
     * @param index 游戏记录序号
     */
    public void get(int index){
        RecordMemento memento = recordList.get(index);
        System.out.println("游戏名称："+memento.getName()+" 分数为:"+memento.getScore());
//        CallStackLogger.log(
//                new CallStackLogInfo(
//                        "RecordList",
//                        "get",
//                        String.valueOf(System.identityHashCode(this)),
//                        "游玩人："+memento.getName()+" 分数："+memento.getScore()
//                )
//        );
    }
}
