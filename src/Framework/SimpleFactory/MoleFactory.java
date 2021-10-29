package Framework.SimpleFactory;

public class MoleFactory {
    //创建并初始化角色
    public Mole createMole(String role,String color){
        MoleIngredientFactory moleIngredientFactory=new MoleIngredientFactory();
        Mole mole=new Mole();
        mole.setMoleRole(moleIngredientFactory.setRole(role));
        mole.setMoleColor(moleIngredientFactory.setColor(color));
        mole.setMoleName(color+role);
        if(mole.getMoleRole().getRole()=="Molele"){
            mole.setMoney(500);
            mole.setTicket(0);
            mole.setScore(0);
        }
        else if(mole.getMoleRole().getRole()=="Momo"){
            mole.setMoney(600);
            mole.setTicket(0);
            mole.setScore(0);
        }
        else if(mole.getMoleRole().getRole()=="Kura"){
            mole.setMoney(400);
            mole.setTicket(0);
            mole.setScore(0);
        }
        return mole;
    }
}
