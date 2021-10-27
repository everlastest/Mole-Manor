package MoleFarm.pattern.builder.conc;

import MoleFarm.FarmGrowth;
import MoleFarm.common.product.AbstractSeed;
import MoleFarm.common.product.fertilizer.MiddleFertilizer;
import MoleFarm.pattern.builder.Builder;

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
