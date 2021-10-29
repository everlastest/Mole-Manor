package MoleFarm;

import Singleton_LazyInitialization.MoleManor;
import MoleFarm.common.Home;

public class Program {
    public static void main(String[] args) throws CloneNotSupportedException {
        MoleManor MM = MoleManor.getInstance();
        MM.flowController();
        System.out.println(MM.getPlayer());
        System.out.println(Home.mole);
         FarmProcess farmProcess = FarmProcess.newInstance();
        //mole.setMoney(100);
        farmProcess.process();
    }
}
