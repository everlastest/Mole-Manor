package MoleAmuse.GamePackage;

import ChatRoom.Chatroom;
import Framework.SimpleFactory.Mole;
import Framework.Composite.*;

import java.util.Scanner;

public class GameUI {
    private Mole mole;
    private GameMaker gameMaker=GameMaker.getInstance();
    private MenuList menuList=MenuList.getInstance();
    private Component amuseMenu;

    public GameUI(Mole mole){
        this.mole=mole;
        this.amuseMenu=menuList.getMenulist("摩尔游乐园");
    }

    public void playGame(){
        amuseMenu.printMenu();
        while(true){
            Scanner scan = new Scanner(System.in);
            switch(scan.nextInt()){
                case 1:
                    gameMaker.playCooking();
                    break;
                case 2:
                    gameMaker.playRacing();
                    break;
                case 3:
                    gameMaker.playTictactoe();
                    break;
                case 0:
                    System.out.println("已离开游乐园，即将返回摩尔大厅！！！\n\n\n");
                default:
                    break;
            }
        }
    }
}