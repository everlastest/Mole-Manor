package Framework.SimpleFactory;

import Framework.SimpleFactory.Color.Color;
import Framework.SimpleFactory.Role.Role;

//摩尔角色相关信息
public class Mole {
    private String MoleName;      //名字
    private Role MoleRole;      //角色
    private Color MoleColor;      //颜色
    private int money;      //摩尔豆
    private int ticket;      //游乐园票数
    private int score;      //游戏积分

    public Mole(){
    }
    private Mole(Role role,Color color){
        MoleRole=role;
        MoleColor=color;
        MoleName= MoleColor.getColor()+MoleRole.getRole();

        if(role.getRole()=="Molele")
        {
            money=500;
            ticket=0;
            score=0;
        }
        else if(role.getRole()=="Kura")
        {
            money=600;
            ticket=0;
            score=0;
        }
        else if(role.getRole()=="Momo")
        {
            money=400;
            ticket=0;
            score=0;
        }
    }

    //set和get函数
    public void setMoleName(String moleName){
        MoleName=moleName;
    };
    public String getMoleName(){return MoleName;}

    public void setMoleColor(Color moleColor) {
         MoleColor=moleColor;
    }
    public Color getMoleColor(){return MoleColor;}

    public void setMoleRole(Role moleRole){
        MoleRole=moleRole;
    }
    public Role getMoleRole(){return MoleRole;}

    public void setMoney(int money){
        this.money=money;
    }
    public int getMoney(){return money;}

    public void setTicket(int ticket){
        this.ticket=ticket;
    }
    public int getTicket(){return ticket;}

    public void setScore(int score){this.score=score;}
    public int getScore(){return score;}

    public void showMoleInformation(){
        System.out.println("Name is"+MoleName+"!");
        MoleRole.getRole();
        MoleColor.getColor();
    }
}
