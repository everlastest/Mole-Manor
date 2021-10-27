package moleFarm.pattern.command.conc;

import moleFarm.common.Home;
import moleFarm.common.Shop;
import moleFarm.common.product.AbstractFertilizer;

/**
 * 具体命令
 * 仓库向商店发生请求，进货肥料
 */
public class FertilizerCommand {
    /**
     * 命令接收方，商店
     */
    private Shop shop = Home.shop;


    /**
     * 商店接收命令，为仓库买入肥料
     *
     * @param fertilizer
     * @param num
     */
    public void execute(AbstractFertilizer fertilizer, int num) {
        shop.buyFertilizer(fertilizer, num);
    }

}
