package MoleFarm.pattern.builder.conc;

import MoleFarm.FarmGrowth;
import MoleFarm.common.product.AbstractSeed;
import MoleFarm.common.product.fertilizer.AdvancedFertilizer;
import MoleFarm.pattern.builder.Builder;

/**
 * 具体建造着1
 */
public class ConcreteBuilder1 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        FarmGrowth.loosenSoil();
        FarmGrowth.plantSeed(seed, farmBlock);
        FarmGrowth.watering(farmBlock);
        FarmGrowth.weed(farmBlock);
        FarmGrowth.applyFertilizer(new AdvancedFertilizer(), farmBlock);
    }
}
