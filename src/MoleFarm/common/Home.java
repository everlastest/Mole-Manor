package MoleFarm.common;

import Framework.SimpleFactory.Mole;
import Singleton_LazyInitialization.MoleManor;

public class Home {
    public static MoleFarmWarehouse farmWarehouse = MoleFarmWarehouse.getInstance();
    
    public static MoleFarm farm = MoleFarm.getInstance();

    public static Mole mole = MoleManor.getInstance().getPlayer();

    public static Shop shop = Shop.getInstance();
}
