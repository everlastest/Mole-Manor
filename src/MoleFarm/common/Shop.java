package MoleFarm.common;

import MoleFarm.common.product.AbstractCrops;
import MoleFarm.common.product.AbstractFertilizer;
import MoleFarm.common.product.AbstractSeed;

/**
 * 商店类
 * 仓库从商店买入种子、肥料
 * 仓库卖出作物到商店
 */
public class Shop {

    private MoleFarmWarehouse moleFarmWarehouse = Home.farmWarehouse;

    //关联商店与仓库
    private Shop() {
    }

    public static Shop getInstance() {
        return new Shop();
    }

    public boolean buySeeds(AbstractSeed seed, int num) {
        return moleFarmWarehouse.buySeeds(seed, num);
    }

    public boolean buyFertilizer(AbstractFertilizer fertilizer, int num) {
        return moleFarmWarehouse.buyFertilizer(fertilizer, num);
    }

    public boolean sellCrops(AbstractCrops crops, int num) {
        return moleFarmWarehouse.sellCrops(crops, num);
    }
}
