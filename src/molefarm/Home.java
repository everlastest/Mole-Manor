package molefarm;

import molefarm.common.Shop;
import molefarm.pattern.factory.conc.CropsFactory;
import molefarm.pattern.factory.conc.FertilizerFactory;
import molefarm.pattern.factory.conc.SeedFactory;
import molefarm.pattern.factory.conc.ToolFactory;

public class Home {

    public static Shop shop = Shop.getInstance();

    public static SeedFactory seedFactory = SeedFactory.newInstance();

    public static CropsFactory cropsFactory = CropsFactory.newInstance();

    public static FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();

    public static ToolFactory toolFactory = ToolFactory.newInstance();


}
