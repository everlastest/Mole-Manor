package Singleton_LazyInitialization;

public class MainTest {
    private static MainTest instance=new MainTest();
    private MainTest(){ }
    public static MainTest getInstance(){return instance;}
}
