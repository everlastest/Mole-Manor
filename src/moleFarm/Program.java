package moleFarm;

import Singleton_LazyInitialization.MoleManor;

public class Program {
    public static void main(String[] args) throws CloneNotSupportedException {
        MoleManor MM = MoleManor.getInstance();
        MM.flowController();
        FarmProcess.newInstance().process();
    }
}
