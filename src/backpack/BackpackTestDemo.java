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
        controller.DelBackpackItem("夹克","clothes");
        controller.updateView();
    }

    private static Backpack retrieveStudentFromDatabase(){
        Backpack backpack=new Backpack();
        backpack.AddClothes("夹克",1);
        backpack.AddFood("食物",3);
        return backpack;
    }
}
