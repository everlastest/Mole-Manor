package MoleFarm.common.exception.product.conc;

import MoleFarm.common.exception.product.ProductNotFoundException;

public class CropsNotFoundException extends ProductNotFoundException {
    public CropsNotFoundException(String message) {
        super(message);
    }
}
