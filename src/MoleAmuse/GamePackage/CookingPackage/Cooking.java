package MoleAmuse.GamePackage.CookingPackage;

import MoleAmuse.GamePackage.Game;

import java.util.Scanner;

public class Cooking implements Game {
    @Override
    public void Play() {
        System.out.println("启动做菜游戏，请输入你想做的菜：");
        Scanner input=new Scanner(System.in);
        String cook=input.nextLine();
        try{
            System.out.println("准备材料中...");
            Thread.sleep(1500);
            System.out.println("做饭中...");
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(cook+"已做好");
        System.out.println("正在退出做饭游戏......\n成功退出，已返回游乐园！！！");
    }
}
