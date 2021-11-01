package framework.interpreter;

public class Sub implements Expression{
    private Expression left,right;

    public Sub(Expression left,Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public double interpret(){
        return left.interpret()-right.interpret();
    }

}
