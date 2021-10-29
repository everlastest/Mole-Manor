package moleFarm;

import Framework.SimpleFactory.Mole;
import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.common.Shop;
import moleFarm.pattern.factory.conc.CropsFactory;
import moleFarm.pattern.factory.conc.FertilizerFactory;
import moleFarm.pattern.factory.conc.SeedFactory;
import moleFarm.pattern.factory.conc.ToolFactory;
import Singleton_LazyInitialization.MoleManor;

public class Home {

    public static Mole mole = MoleManor.getInstance().getPlayer();

    public static MoleFarmWarehouse farmWarehouse = MoleFarmWarehouse.getInstance();
    
    public static MoleFarm farm = MoleFarm.getInstance();

    public static Shop shop = Shop.getInstance();

    public static SeedFactory seedFactory= SeedFactory.newInstance();

    public static CropsFactory cropsFactory=CropsFactory.newInstance();

    public static FertilizerFactory fertilizerFactory= FertilizerFactory.newInstance();

    public static ToolFactory toolFactory= ToolFactory.newInstance();
}
