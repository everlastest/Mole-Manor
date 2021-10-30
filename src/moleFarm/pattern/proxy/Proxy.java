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
    private FertilizerCommand fertilizerCommand;
    private SeedCommand seedCommand;
    public boolean seedPurchase(AbstractSeed seed, int num){
        seedCommand=new SeedCommand();
        return seedCommand.execute(seed,num);
    }
    public boolean fertilizerPurchase(AbstractFertilizer fertilizer, int num){
        fertilizerCommand=new FertilizerCommand();
        return fertilizerCommand.execute(fertilizer,num);
    }
}
