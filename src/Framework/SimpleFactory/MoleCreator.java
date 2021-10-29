package Framework.SimpleFactory;

import java.util.Scanner;

public class MoleCreator {

    private MoleCreator() {}
    private static MoleCreator instance = new MoleCreator();
    public static MoleCreator getInstance(){
        return instance;
    }

    /**
     * 创建角色
     * @return
     */
    public Mole createMole(){
        Scanner input = new Scanner(System.in);

        System.out.println("请输入你的名字：");
        String name = input.nextLine();

        System.out.println("选择你的角色：[1]Molele [2]Momo [3]Kura");
        int roleNum = input.nextInt();

        System.out.println("选择外观颜色：[1]Red [2]Green [3]Blue");
        int colorNum = input.nextInt();

        String role = "Molele";
        String color = "red";
        switch(roleNum){
            case 1:
                role="Molele";
                break;
            case 2:
                role="Momo";
                break;
            case 3:
                role="Kura";
                break;
            default:
                break;
        }
        switch(colorNum){
            case 1:
                color="Red";
                break;
            case 2:
                color="Green";
                break;
            case 3:
                color="Blue";
                break;
            default:
                break;
        }

        MoleFactory moleFactory = new MoleFactory();
        Mole mole = moleFactory.createMole(role,color);

        mole.setMoleName(name);
        mole.setMoney(1000);
        mole.setTicket(2);
        mole.setScore(0);

        return mole;
    }


}
