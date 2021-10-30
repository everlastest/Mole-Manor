package moleFarm.pattern.command.conc;

import moleFarm.Home;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.common.Shop;
import moleFarm.common.product.AbstractSeed;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.command.Command;

/**
 * 具体命令
 * 仓库发送请求，从商店进货种子
 */
public class SeedCommand extends Command {
    /**
     * 命令接收方，仓库
     */
    private MoleFarmWarehouse moleFarmWarehouse = MoleAdapter.getInstance().getFarmWarehouse();

    /**
     * 商店接收命令，为仓库买入种子
     *
     * @param seed
     * @param num
     */
    public boolean execute(AbstractSeed seed, int num) {
        return moleFarmWarehouse.buySeeds(seed, num);
    }
}
