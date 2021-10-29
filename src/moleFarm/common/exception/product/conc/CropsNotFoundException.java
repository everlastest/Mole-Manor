package moleFarm.common.exception.product.conc;

import moleFarm.common.exception.product.ProductNotFoundException;

public class CropsNotFoundException extends ProductNotFoundException {
    public CropsNotFoundException(String message) {
        super(message);
    }
}
