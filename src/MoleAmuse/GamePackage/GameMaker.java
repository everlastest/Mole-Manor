package MoleAmuse.GamePackage;

import MoleAmuse.GamePackage.CookingPackage.Cooking;
import MoleAmuse.GamePackage.RacingPackage.Racing;
import MoleAmuse.GamePackage.TictactoePackage.Tictactoe;


//外观模式
public class GameMaker {

    private Game tictactoe;
    private Game cooking;
    private Game racing;

    public GameMaker() {
        tictactoe = new Tictactoe();
        cooking = new Cooking();
        racing = new Racing();
    }

    //井字棋游戏接口
    public void playTictactoe(){
        tictactoe.Play();
    }

    //做菜游戏接口
    public void playCooking(){
        cooking.Play();
    }

    //赛车游戏接口
    public void playRacing(){
        racing.Play();
    }


}

