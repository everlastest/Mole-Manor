package chatroom.test;

import chatroom.robotpackage.Robot;

public class MultipletonTest {
    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用多例ing----");

        String npc1 = "我是" + Robot.getInstance("菩提大伯").getRobotName();
        String npc2 = "我是" + Robot.getInstance("么么公主").getRobotName();
        String npc3 = "我是" + Robot.getInstance("瑞琪").getRobotName();
        System.out.println(npc1 + "\n" + npc2 + "\n" + npc3);

        Robot r = Robot.getInstance("小摩尔");
    }

    public static void main(String[] args) {

        MultipletonTest.test();
    }
}
