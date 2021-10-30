package MoleAmuse.GamePackage.Test;

import MoleAmuse.GamePackage.GameMaker;
import MoleAmuse.GamePackage.MementoPackage.RecordList;

public class MementoTestDemo {
    public static void main(String[] args) {
        RecordList r = RecordList.getInstance();
        r.printList();

        GameMaker.getInstance().playtestGame1();
        GameMaker.getInstance().playtestGame2();

        r.printList();
        r.getRecord(1);
        r.getRecord(3);
    }
}
