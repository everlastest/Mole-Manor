package framework.blackboard;

public class BlackboardTestDemo {
    public static void test(){

        Blackboard blackboard = new Blackboard();

        Control control = new Control(blackboard);
        control.addNotice("test");
        control.addAllNotice();

        blackboard.show();
    }
    public static void main(String[] args){
        test();
    }
}
