package chatroom.robotpackage;

import java.util.ArrayList;

public class NPCList {

    private ArrayList<Robot> NpcList = new ArrayList<>();

    private NPCList() {}
    private static NPCList instance = new NPCList();
    public static NPCList getInstance(){
        return instance;
    }


    /**
     * 获取三个NPC的实例并添加到NPC列表中
     */
    public void start(){
        Robot UnclePuti = Robot.getInstance("菩提大伯");
        Robot PrincessMeme = Robot.getInstance("么么公主");
        Robot Ruiqi = Robot.getInstance("瑞琪");

        UnclePuti.start();
        PrincessMeme.start();
        Ruiqi.start();

        NpcList.add(UnclePuti);
        NpcList.add(PrincessMeme);
        NpcList.add(Ruiqi);
    }

    /**
     * 停用NPC
     */
    public void stop(){
        for(Robot r : NpcList){
            r.stop();
        }
    }
}
