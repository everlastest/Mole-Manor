package MoleFarm;

import MoleFarm.pattern.adapter.Mole;

public class Home {
    public static MoleFarmWarehouse farmWarehouse = MoleFarmWarehouse.getInstance();
    
    public static MoleFarm farm = MoleFarm.getInstance();

    public static Mole mole = Mole.getInstance();

    public static Shop shop = Shop.getInstance();
}
