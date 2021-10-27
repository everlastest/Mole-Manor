package MoleFarm;

import MoleFarm.common.exception.product.conc.SeedNotFoundException;
import MoleFarm.common.product.AbstractCrops;
import MoleFarm.common.product.AbstractSeed;

import java.util.List;

/**
 * 定义农场行为
 */
public interface IFarm {
    /**
     * 一键种植种子
     *
     * @param seed
     */
    void plantBatchSeeds(AbstractSeed seed) throws SeedNotFoundException;

    /**
     * 种植种子
     *
     * @param seed
     */
    void plantSeeds(AbstractSeed seed);

    /**
     * 收获作物
     */
    List<AbstractCrops> harvestCrops();
}
