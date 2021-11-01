package framework.interpreter;

import singletonlazyinitialization.MoleManor;

public class Number implements Expression {

    private double number;

    public Number(double number){
        this.number=number;
    }
    @Override
    public double interpret(){
        return number;
    }

}
