import Singleton_LazyInitialization.MoleManor;

import java.util.Scanner;

/**
 * 项目主流程
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException,InterruptedException {
        System.out.println("欢迎来到摩尔庄园！");
        System.out.println("选择运行方式：[1]游玩模式 [2]测试模式");
        Scanner input=new Scanner(System.in);
        int key=input.nextInt();
        if(key==1){
            MoleManor MM=MoleManor.getInstance();
            MM.flowController();
        }
        else if(key==2){
            System.out.println("测试模式！");

        }
    }
}
