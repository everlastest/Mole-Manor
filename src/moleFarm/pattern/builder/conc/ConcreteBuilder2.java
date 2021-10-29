package moleFarm.pattern.builder.conc;

import moleFarm.common.FarmGrowth;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.product.fertilizer.MiddleFertilizer;
import moleFarm.pattern.builder.Builder;

/**
 * 具体建造者2
 */
public class ConcreteBuilder2 extends Builder {
    @Override
    public void buildPlant(AbstractSeed seed) {
        FarmGrowth.plantSeed(seed, farmBlock);
        FarmGrowth.applyFertilizer(new MiddleFertilizer(), farmBlock);
    }

}
