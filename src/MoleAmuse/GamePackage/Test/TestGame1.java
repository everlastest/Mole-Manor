package MoleAmuse.GamePackage.Test;

import MoleAmuse.GamePackage.Game;
import MoleAmuse.GamePackage.MementoPackage.*;

public class TestGame1 implements Game {
    @Override
    public void Play() {
        System.out.println("playing game1...");
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(10,"game1");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());
    }

}
