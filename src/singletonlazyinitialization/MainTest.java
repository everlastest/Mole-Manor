package singletonlazyinitialization;

import backpack.MVCTest;
import chatroom.test.MediatorTest;
import chatroom.test.MultipletonTest;
import chatroom.test.MutexTest;
import framework.test.BlackboardTest;
import framework.test.ComponentTest;
import framework.test.InterpreterTest;
import moleamuse.test.FacadeTest;
import moleamuse.test.FlyweightTest;
import moleamuse.test.MementoTest;
import moleamuse.test.TemplateTest;
import molefarm.common.MoleFarmBlock;
import molefarm.test.adapter.AdapterTest;
import molefarm.test.builder.BuilderTest;
import molefarm.test.chainOfResponsibility.ChainOfResponsibilityTest;
import molefarm.test.command.CommandTest;
import molefarm.test.factory.FactoryTest;
import molefarm.test.iterator.IteratorTest;
import molefarm.test.observer.ObserverTest;
import molefarm.test.proxy.ProxyTest;
import molefarm.test.state.StateTest;

import java.lang.reflect.Method;

public class MainTest {
    private static MainTest instance=new MainTest();
    private MainTest(){ }
    public static MainTest getInstance(){return instance;}

    //测试流程控制器
    public void TestController() throws InterruptedException {
        //moleFarm模块测试
        AdapterTest();
        BuilderTest();
        ChainOfResponsibilityTest();
        CommandTest();
        FactoryTest();
        IteratorTest();
        ObserverTest();
        ProxyTest();
        StateTest();
        blackboardTest();
        compositeTest();
        interpreterTest();
        MVCTest();
        FacadeTest();
        FlyweightTest();
        MementoTest();
        PrototypeTest();
        TemplateTest();
        MediatorTest();
        MutexTest();
        MultipletonTest();
    }

    //1 适配器模式（Adapter Pattern）
    public void AdapterTest() {
        System.out.println("1 适配器模式（Adapter Pattern）");
        System.out.println("包：molefarm.pattern.adapter");
        System.out.println("类：MoleAdapter/WeatherAdapter");
        System.out.println("实现接口：WeatherAdapter.getInstance()");
        System.out.println("测试信息：");
        AdapterTest.WeatherTest();
        System.out.println();
    }

    //2 建造者模式（Builder Pattern）
    public void BuilderTest() {
        System.out.println("2 建造者模式（Builder Pattern）");
        System.out.println("包：molefarm.pattern.builder");
        System.out.println("类：ConcreteBuilder1/ConcreteBuilder2");
        System.out.println("实现接口：ConcreteBuilder1.buildPlant()");
        System.out.println("测试信息：");
        BuilderTest.builder1(new MoleFarmBlock(), BuilderTest.createSeed("白菜种子"));
        System.out.println();
    }

    //3 职责链模式（ChainOfResponsibility Pattern）
    public void ChainOfResponsibilityTest() {
        System.out.println("3 职责链模式（ChainOfResponsibility Pattern）");
        System.out.println("包：molefarm.pattern.chainOfResponsibility");
        System.out.println("类：ShopHandler/WareHouseHandler");
        System.out.println("实现接口：ShopHandler.provideSeeds()");
        System.out.println("测试信息：");
        ChainOfResponsibilityTest.test();
        System.out.println();
    }

    //4 命令模式（Command Pattern）
    public void CommandTest() {
        System.out.println("4 命令模式（Command Pattern）");
        System.out.println("包：molefarm.pattern.command");
        System.out.println("类：FertilizerCommand/SeedCommand");
        System.out.println("实现接口：FertilizerCommand.excute()");
        System.out.println("测试信息：");
        CommandTest.test();
        System.out.println();
    }

    //5 工厂模式（Factory Pattern）
    public void FactoryTest() {
        System.out.println("5 工厂模式（Factory Pattern）");
        System.out.println("包：molefarm.pattern.factory");
        System.out.println("类：CropsFactory/FertilizerFactory/SeedFactory/ToolFactory");
        System.out.println("实现接口：CropsFactory.newInstance()");
        System.out.println("测试信息：");
        FactoryTest.produceSeed("白菜种子");
        System.out.println();
    }

    //6 迭代器模式（Iterator Pattern）
    public void IteratorTest() {
        System.out.println("6 迭代器模式（Iterator Pattern）");
        System.out.println("包：molefarm.pattern.iterator");
        System.out.println("类：FarmIterator");
        System.out.println("实现接口：Farm.getIterator()");
        System.out.println("测试信息：");
        IteratorTest.test();
        System.out.println();
    }

    //7 观察者模式（Observer Pattern）
    public void ObserverTest() {
        System.out.println("7 观察者模式（Observer Pattern）");
        System.out.println("包：molefarm.pattern.observer");
        System.out.println("类：WeatherObserver");
        System.out.println("实现接口：WeatherObserver.getInstance()");
        System.out.println("测试信息：");
        ObserverTest.test();
        System.out.println();
    }

    //8 代理模式（Proxy Pattern）
    public void ProxyTest() {
        System.out.println("8 代理模式（Proxy Pattern）");
        System.out.println("包：molefarm.pattern.proxy");
        System.out.println("类：Proxy");
        System.out.println("实现接口：Proxy.getInstance()");
        System.out.println("测试信息：");
        ProxyTest.test();
        System.out.println();
    }

    //9 状态模式（State Pattern）
    public void StateTest() {
        System.out.println("9 状态模式（State Pattern）");
        System.out.println("包：molefarm.pattern.state");
        System.out.println("类：CloudyWeather/InsectDamageWeather/RainWeather/SunnyWeather");
        System.out.println("实现接口：CloudyWeather.getWeather()");
        System.out.println("测试信息：");
        ClassLoader classLoader = StateTest.class.getClassLoader();
        try {
            Class<?> loadClass = classLoader.loadClass("molefarm.test.state.StateTest");
            Method method = loadClass.getMethod("main", String[].class);
            method.invoke(null, new Object[] { new String[] {} } );
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    //10 黑板模式
    public void blackboardTest() {
        System.out.println("10 黑板模式（Blackboard Pattern)");
        System.out.println("包:framework.blackboard");
        System.out.println("类：BlackBoard");
        System.out.println("实现接口：blackboard.show()");
        System.out.println("测试信息：");
        BlackboardTest.test();
        System.out.println();
    }

    //11 组合模式
    public void compositeTest(){
        System.out.println("11 组合模式（Composite Pattern)");
        System.out.println("包:framework.composite");
        System.out.println("类：Menu/MenuList/Component");
        System.out.println("实现接口：menu.add(menu1, menu2, menu3)");
        System.out.println("测试信息：");
        ComponentTest.test();
        System.out.println();
    }

    //12 解释器模式
    public void interpreterTest(){
        System.out.println("12 解释器模式（Interpreter Pattern)");
        System.out.println("包:framework.interpreter");
        System.out.println("类：Sub/Number/BuyTicket");
        System.out.println("实现接口：by.buyTicket()");
        System.out.println("测试信息：");
        InterpreterTest.test();
        System.out.println();
    }

    //13 MVC模式
    public void MVCTest(){
        System.out.println("13 MVC模式（MVC Pattern)");
        System.out.println("包:backpack.MVC");
        System.out.println("类：Backpack/BackpackController/BackpackView");
        System.out.println("实现接口：controller.updateView()");
        System.out.println("测试信息：");
        MVCTest.test();
        System.out.println();
    }

    //14 外观模式
    public void FacadeTest(){
        System.out.println("14 外观模式（Facade Pattern)");
        System.out.println("包:moleamuse");
        System.out.println("类：Game/GameMaker");
        System.out.println("实现接口：gameMaker.play()");
        System.out.println("测试信息：");
        FacadeTest.test();
        System.out.println();
    }

    //15 享元模式
    public void FlyweightTest(){
        System.out.println("15 享元模式（Flyweight Pattern)");
        System.out.println("包:moleamuse.tictactoepackage");
        System.out.println("类：TictactoeFactory");
        System.out.println("实现接口：f.getChessObject()");
        System.out.println("测试信息：");
        FlyweightTest.test();
        System.out.println();
    }

    //16 备忘录模式
    public void MementoTest(){
        System.out.println("16 备忘录模式（Memento Pattern)");
        System.out.println("包:moleamuse.mementopackage");
        System.out.println("类：RecordList/RecordMemento/ScoreOriginator");
        System.out.println("实现接口：r.getRecord()");
        System.out.println("测试信息：");
        MementoTest.test();
        System.out.println();
    }

    //17 原型模式
    public void PrototypeTest(){
        System.out.println("17 原型模式（Prototype Pattern)");
        System.out.println("包:moleamuse.cookingpackage.prototype");
        System.out.println("类：AbstractMeal/GongBaoJiDing/SuanCaiYu/TangCuLiJi");
        System.out.println("实现接口：MealCache.getMeal()");
        System.out.println("测试信息：");
        ProxyTest.test();
        System.out.println();
    }

    //18 模板模式
    public void TemplateTest(){
        System.out.println("18 模板模式（Template Pattern)");
        System.out.println("包:moleamuse.racingpackage.template");
        System.out.println("类：AbstractRacing/DriftRace/ObstacleRace/TimeRace");
        System.out.println("实现接口：abstractRacing.StartRacing()");
        System.out.println("测试信息：");
        TemplateTest.test();
        System.out.println();
    }

    //19 中介者模式
    public void MediatorTest(){
        System.out.println("19 中介者模式（Mediator Pattern)");
        System.out.println("包:chatroom");
        System.out.println("类：Chatroom");
        System.out.println("实现接口：Chatroom.addMessage()");
        System.out.println("测试信息：");
        MediatorTest.test();
        System.out.println();
    }

    //20 互斥模式
    public void MutexTest(){
        System.out.println("20 互斥模式（Mutex Pattern)");
        System.out.println("包:chatroom/mutex");
        System.out.println("类：Lock/Mutex");
        System.out.println("实现接口：mutex.acquire()/mutex.release()");
        System.out.println("测试信息：");
        MutexTest.test();
        System.out.println();
    }

    //21 多例模式
    public void MultipletonTest(){
        System.out.println("21 多例模式（Multipleton Pattern)");
        System.out.println("包:chatroom/robotpackage");
        System.out.println("类：Robot");
        System.out.println("实现接口：Robot.getInstance()");
        System.out.println("测试信息：");
        MultipletonTest.test();
        System.out.println();
    }
    public static void main(String[] args) throws InterruptedException {
        MainTest mainTest = new MainTest();
        mainTest.TestController();
    }
}