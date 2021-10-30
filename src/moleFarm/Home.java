package moleFarm;

import moleFarm.common.Shop;
import moleFarm.pattern.factory.conc.CropsFactory;
import moleFarm.pattern.factory.conc.FertilizerFactory;
import moleFarm.pattern.factory.conc.SeedFactory;
import moleFarm.pattern.factory.conc.ToolFactory;

public class Home {

    public static Shop shop = Shop.getInstance();

    public static SeedFactory seedFactory = SeedFactory.newInstance();

    public static CropsFactory cropsFactory = CropsFactory.newInstance();

    public static FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();

    public static ToolFactory toolFactory = ToolFactory.newInstance();


}
