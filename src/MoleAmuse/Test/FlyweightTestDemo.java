package MoleAmuse.Test;

import MoleAmuse.TictactoePackage.Object.AbstractChess;
import MoleAmuse.TictactoePackage.TictactoeFactory;

public class FlyweightTestDemo {
    public static void main(String[] args) {

        TictactoeFactory f = TictactoeFactory.getInstance();
        AbstractChess chess1 = f.getChessObject('W');
        AbstractChess chess2 = f.getChessObject('W');

        System.out.println(chess1 == chess2);
    }
}
