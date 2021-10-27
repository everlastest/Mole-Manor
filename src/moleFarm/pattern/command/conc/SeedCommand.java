package moleFarm.pattern.command.conc;

import moleFarm.common.Shop;
import moleFarm.common.product.AbstractSeed;

/**
 * 具体命令
 * 仓库发送请求，从商店进货种子
 */
public class SeedCommand {
    /**
     * 命令接收方，商店
     */
    private Shop shop = Shop.getInstance();

    /**
     * 商店接收命令，为仓库买入种子
     *
     * @param seed
     * @param num
     */
    public void execute(AbstractSeed seed, int num) {
        shop.buySeeds(seed, num);
    }

}
