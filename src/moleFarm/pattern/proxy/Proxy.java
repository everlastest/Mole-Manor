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
    public boolean seedPurchase(String name, int num){
        seedCommand=new SeedCommand();
        return seedCommand.execute(name,num);
    }
    public boolean fertilizerPurchase(String name, int num){
        fertilizerCommand=new FertilizerCommand();
        return fertilizerCommand.execute(name,num);
    }
}
