package MoleFarm.pattern.factory.conc;

import MoleFarm.common.exception.product.ProductNotFoundException;
import MoleFarm.common.exception.product.conc.FertilizerNotFoundException;
import MoleFarm.common.product.AbstractFertilizer;
import MoleFarm.common.utils.JsonOp;
import MoleFarm.pattern.factory.Factory;

/**
 * 肥料的抽象工厂类，此处不再写具体的，如PrimaryFertilizerFactory
 */
public class FertilizerFactory implements Factory {
    private final static String PATH = JsonOp.getPathJson("FertilizerFactory");
    private final static String MSG = JsonOp.getMsgJson("FertilizerFactory");
    private static volatile FertilizerFactory fertilizerFactory;

    private FertilizerFactory() {
    }

    public synchronized static FertilizerFactory newInstance() {
        if (fertilizerFactory == null) {
            fertilizerFactory = new FertilizerFactory();
        }
        return fertilizerFactory;
    }

    @Override
    public AbstractFertilizer create(String name) throws FertilizerNotFoundException {
        try {
            return Factory.createProduct(PATH + name);
        } catch (ProductNotFoundException e) {
            throw new FertilizerNotFoundException(MSG);
        }
    }
}
