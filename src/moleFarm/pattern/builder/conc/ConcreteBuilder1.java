package moleFarm.pattern.builder.conc;

import moleFarm.common.FarmGrowth;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.product.fertilizer.AdvancedFertilizer;
import moleFarm.pattern.builder.Builder;

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
