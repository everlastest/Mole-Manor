package SimpleFactory;

import SimpleFactory.Color.Blue;
import SimpleFactory.Color.Color;
import SimpleFactory.Color.Green;
import SimpleFactory.Color.Red;
import SimpleFactory.Role.Molele;
import SimpleFactory.Role.Momo;
import SimpleFactory.Role.Role;

public class MoleIngredientFactory {
    //设置角色
    public Role setRole(String role){
        if(role==null){
            return null;
        }
        if(role.equalsIgnoreCase("Lily")){
            return new Momo();
        }
        else if(role.equalsIgnoreCase("Molele")){
            return new Molele();
        }
        else if(role.equalsIgnoreCase("Momo")){
            return new Momo();
        }
        return null;
    }

    //设置颜色
    public Color setColor(String color){
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("Red")){
            return new Red();
        }
        else if(color.equalsIgnoreCase("Green")){
            return new Green();
        }
        else if(color.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        return null;
    }

}
