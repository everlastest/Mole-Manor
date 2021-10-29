package MoleAmuse.GamePackage;

import Framework.SimpleFactory.Mole;
import Framework.Composite.*;

import java.util.Scanner;

public class GameUI {

    private GameMaker gameMaker = GameMaker.getInstance();
    private MenuList menuList = MenuList.getInstance();
    private Component amuseMenu;

    public GameUI(){
        this.amuseMenu = menuList.getMenulist("摩尔游乐园");
    }

    public void playGame(){
        while(true){
            amuseMenu.printMenu();
            Scanner scan = new Scanner(System.in);
            switch(scan.nextInt()){
                case 1:
                    gameMaker.playCooking();
                    break;
                case 2:
                    System.out.println("\n正在进入摩摩赛车城！");
                    gameMaker.playRacing();
                    break;
                case 3:
                    gameMaker.playTictactoe();
                    break;
                case 0:
                    System.out.println("\n已离开游乐园，即将返回摩尔大厅！！！\n\n\n");
                default:
                    break;
            }
        }
    }
}