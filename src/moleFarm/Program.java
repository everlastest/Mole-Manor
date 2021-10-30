package moleFarm;

import Singleton_LazyInitialization.MoleManor;
import moleFarm.pattern.adapter.conc.MoleAdapter;

public class Program {
    public static void main(String[] args) throws CloneNotSupportedException {
        MoleManor MM = MoleManor.getInstance();
        MM.flowController();
        FarmProcess farmProcess = FarmProcess.newInstance();
        farmProcess.process();
    }
}
