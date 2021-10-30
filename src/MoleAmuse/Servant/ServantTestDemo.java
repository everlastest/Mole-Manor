package MoleAmuse.Servant;

import MoleAmuse.GamePackage.GameUI;
import MoleAmuse.GamePackage.GameMaker;

public class ServantTestDemo {
    public static void main(String args[]){
        GameMaker gameMaker=GameMaker.getInstance();

        Worker worker1=new Worker();
        worker1.prepare((Preparation) gameMaker);

        Worker worker2=new Worker();
        worker2.prepare((Preparation) gameMaker);

        Worker worker3=new Worker();
        worker3.prepare((Preparation) gameMaker);

        System.out.println("工作人员已经将游乐设施准备好！");
    }
}
