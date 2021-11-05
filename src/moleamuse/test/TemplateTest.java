package moleamuse.test;

import moleamuse.racingpackage.template.*;
import singletonlazyinitialization.MoleManor;

public class TemplateTest {

    /**
     * @test
     */
    public static void test(){
        System.out.println("----调用模板模式ing----");

        MoleManor moleManor = MoleManor.getInstance();
        moleManor.test();
        AbstractRacing r1 = new TimeRace();
        AbstractRacing r2 = new DriftRace();
        AbstractRacing r3 = new ObstacleRace();
        r1.test();
        r2.test();
        r3.test();

    }

    public static void main(String[] args) {
        TemplateTest.test();
    }
}
