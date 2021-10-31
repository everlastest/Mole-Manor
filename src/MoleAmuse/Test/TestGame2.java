package MoleAmuse.Test;

import MoleAmuse.Game;
import MoleAmuse.MementoPackage.RecordList;
import MoleAmuse.MementoPackage.ScoreOriginator;

public class TestGame2 implements Game {
    @Override
    public void Play() {
        System.out.println("playing game2...");
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        scoreOriginator.setRecord(100,"game2");
        RecordList.getInstance().add(scoreOriginator.saveRecordToMemento());
    }
}
