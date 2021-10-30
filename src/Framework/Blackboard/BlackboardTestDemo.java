package Framework.Blackboard;

public class BlackboardTestDemo {
    public static void main(String[] args){

        Blackboard blackboard = new Blackboard();

        Control control = new Control(blackboard);
        control.addNotice("test");
        control.addAllNotice();

        blackboard.show();
    }
}
