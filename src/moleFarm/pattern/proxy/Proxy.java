package moleFarm.pattern.proxy;

import moleFarm.common.product.AbstractFertilizer;
import moleFarm.common.product.AbstractSeed;
import moleFarm.pattern.command.conc.FertilizerCommand;
import moleFarm.pattern.command.conc.SeedCommand;

/**
 * 代理模式
 * 仓库向商店进货
 */
public class Proxy {
    private static FertilizerCommand fertilizerCommand;
    private static SeedCommand seedCommand;
    public static void seedPurchase(AbstractSeed seed, int num){
        seedCommand=new SeedCommand();
        seedCommand.execute(seed,num);
    }
    public static void fertilizerPurchase(AbstractFertilizer fertilizer, int num){
        fertilizerCommand=new FertilizerCommand();
        fertilizerCommand.execute(fertilizer,num);
    }
}
