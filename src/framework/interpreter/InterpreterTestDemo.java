package framework.interpreter;

import framework.simplefactory.Mole;
import singletonlazyinitialization.MoleManor;

public class InterpreterTestDemo {
    public static void main(String []args){
        MoleManor moleManor=MoleManor.getInstance();
        moleManor.test();
        Mole mole= MoleManor.getPlayer();
        BuyTicket by=new BuyTicket(mole);
        by.buyTicket();
    }
}
