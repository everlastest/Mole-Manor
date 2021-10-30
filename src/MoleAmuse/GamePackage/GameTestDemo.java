package MoleAmuse.GamePackage;

import Framework.SimpleFactory.Mole;
import MoleAmuse.GamePackage.MementoPackage.RecordList;
import MoleAmuse.GamePackage.MementoPackage.ScoreOriginator;
import Singleton_LazyInitialization.MoleManor;


public class GameTestDemo {

    public static void main(String[] args) {
        MoleManor moleManor = MoleManor.getInstance();
        moleManor.test();
        ScoreOriginator scoreOriginator = new ScoreOriginator();
        RecordList pointRecordList = new RecordList();
        GameMaker gameMaker = new GameMaker();


        gameMaker.playTictactoe();
        scoreOriginator.setRecord(10,"五子棋游戏");
        pointRecordList.add(scoreOriginator.saveRecordToMemento());
        System.out.println("\n当前游戏名称："+scoreOriginator.getName()+"\n当前分数为:"+scoreOriginator.getScore()+"\n");

        gameMaker.playCooking();
        scoreOriginator.setRecord(20,"做饭小游戏");
        pointRecordList.add(scoreOriginator.saveRecordToMemento());
        System.out.println("\n当前游戏名称："+scoreOriginator.getName()+"\n当前分数为:"+scoreOriginator.getScore()+"\n");

        gameMaker.playRacing();
        scoreOriginator.setRecord(30,"赛车游戏");
        pointRecordList.add(scoreOriginator.saveRecordToMemento());
        System.out.println("\n当前游戏名称："+scoreOriginator.getName()+"\n当前分数为:"+scoreOriginator.getScore()+"\n");

        System.out.println("\n开始打印得分备忘录内容...");
        for (int i=2;i>=0;i--) {
            pointRecordList.get(i);
        }
    }
}
