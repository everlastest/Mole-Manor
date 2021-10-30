package moleFarm.pattern.command.conc;

import moleFarm.Home;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.common.Shop;
import moleFarm.common.exception.product.conc.FertilizerNotFoundException;
import moleFarm.common.exception.product.conc.SeedNotFoundException;
import moleFarm.common.product.AbstractFertilizer;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.product.IProduct;
import moleFarm.common.utils.JsonOp;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.command.Command;
import moleFarm.pattern.factory.conc.FertilizerFactory;
import moleFarm.pattern.factory.conc.SeedFactory;

import java.util.Map;

/**
 * 具体命令
 * 仓库向商店发生请求，进货肥料
 */
public class FertilizerCommand implements Command {
    private final Map<String, String> map = JsonOp.searchMapper();
    private FertilizerFactory fertilizerFactory = FertilizerFactory.newInstance();
    /**
     * 命令接收方，仓库
     */
    private MoleFarmWarehouse moleFarmWarehouse = MoleAdapter.getInstance().getFarmWarehouse();

    /**
     * 商店接收命令，为仓库买入肥料
     *
     * @param name
     * @param num
     */

    public boolean execute(String name, int num) {
        AbstractFertilizer fertilizer =null;
        try{
            fertilizer = fertilizerFactory.create(map.get(name));
        } catch (FertilizerNotFoundException e){e.printStackTrace();}
        return moleFarmWarehouse.buyFertilizer(fertilizer, num);
    }

}
