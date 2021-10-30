package moleFarm.pattern.command.conc;

import moleFarm.Home;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.common.Shop;
import moleFarm.common.product.AbstractFertilizer;
import moleFarm.common.product.IProduct;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.command.Command;

/**
 * 具体命令
 * 仓库向商店发生请求，进货肥料
 */
public class FertilizerCommand implements Command {
    /**
     * 命令接收方，仓库
     */
    private MoleFarmWarehouse moleFarmWarehouse = MoleAdapter.getInstance().getFarmWarehouse();

    /**
     * 商店接收命令，为仓库买入肥料
     *
     * @param fertilizer
     * @param num
     */
    @Override
    public boolean execute(AbstractFertilizer fertilizer, int num) {
        return moleFarmWarehouse.buyFertilizer(fertilizer, num);
    }

    @Override
    public boolean execute(IProduct product, int num) {
        if(product instanceof AbstractFertilizer)
        return moleFarmWarehouse.buyFertilizer((AbstractFertilizer) product, num);
    }
}
