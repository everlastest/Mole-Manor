package framework.interpreter;

public class Mul implements Expression{
    private Expression left,right;

    public Mul(Expression left,Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public double interpret(){
        return left.interpret()*right.interpret();
    }

}
