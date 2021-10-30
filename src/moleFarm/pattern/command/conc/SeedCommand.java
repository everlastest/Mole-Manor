package moleFarm.pattern.command.conc;

import moleFarm.Home;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.common.Shop;
import moleFarm.common.exception.MyException;
import moleFarm.common.exception.product.conc.SeedNotFoundException;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.utils.JsonOp;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.command.Command;
import moleFarm.pattern.factory.conc.SeedFactory;

import java.util.Map;

/**
 * 具体命令
 * 仓库发送请求，从商店进货种子
 */
public class SeedCommand implements Command {
    private final Map<String, String> map = JsonOp.searchMapper();
    private SeedFactory seedFactory = SeedFactory.newInstance();
    /**
     * 命令接收方，仓库
     */
    private MoleFarmWarehouse moleFarmWarehouse = MoleAdapter.getInstance().getFarmWarehouse();

    /**
     * 商店接收命令，为仓库买入种子
     *
     * @param name
     * @param num
     */
    public boolean execute(String name, int num) {
        AbstractSeed seed =null;
        try{
            seed = seedFactory.create(map.get(name));
        } catch (SeedNotFoundException e){e.printStackTrace();}
        return moleFarmWarehouse.buySeeds(seed, num);
    }
}
