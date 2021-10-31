package backpack;
import backpack.MVC.*;
public class BackpackTestDemo {
    public static void main(String[] args) {

        Backpack model= retrieveStudentFromDatabase();
        BackpackView view=new BackpackView();
        BackpackController controller=new BackpackController(model,view);
        controller.updateView();
        System.out.println();
        //controller.a("夹克",1);
        controller.AddBackpackItem("夹克",1,"clothes");
        controller.updateView();
    }

    private static Backpack retrieveStudentFromDatabase(){
        Backpack backpack = new Backpack();
        backpack.Addclothes("夹克",1);
        backpack.Addfood("食物",3);
        return backpack;
    }
}
