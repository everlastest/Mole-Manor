package MoleAmuse.GamePackage;


import ExceptionHandle.ExceptionHandle;
import MoleAmuse.GamePackage.MementoPackage.RecordList;
import Singleton_LazyInitialization.MoleManor;
import MoleAmuse.Servant.Preparation;
import MoleAmuse.Servant.Worker;

import java.util.Scanner;

public class GameUI {

    private GameMaker gameMaker = GameMaker.getInstance();


    public GameUI(){
    }

    public void playGame(){

        while(true){

            MoleManor.printMenu();

            Scanner scan = new Scanner(System.in);
            ExceptionHandle exceptionHandle = new ExceptionHandle();
            int i = exceptionHandle.exception();

            MoleManor.moveTo(i - 1);

            switch(i){
                case 1:
                    //Worker worker1=new Worker();
                    //worker1.prepare((Preparation) gameMaker);
                    gameMaker.playCooking();
                    break;
                case 2:
                    //Worker worker2=new Worker();
                    //worker2.prepare((Preparation) gameMaker);
                    System.out.println("\n正在进入摩摩赛车场！");
                    gameMaker.playRacing();
                    break;
                case 3:
                    //Worker worker3=new Worker();
                    //worker3.prepare((Preparation) gameMaker);
                    gameMaker.playTictactoe();
                    break;
                case 4:
                    RecordList.getInstance().printList();
                    break;
                case 0:
                    MoleManor.goback();
                    System.out.println("\n已离开游乐园，即将返回摩尔大厅！！！\n\n\n");
                    return;
                default:
                    break;
            }

            MoleManor.goback();

        }
    }
}