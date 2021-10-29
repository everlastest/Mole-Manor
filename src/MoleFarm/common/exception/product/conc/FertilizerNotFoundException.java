package MoleFarm.common.exception.product.conc;

import MoleFarm.common.exception.product.ProductNotFoundException;

public class FertilizerNotFoundException extends ProductNotFoundException {
    public FertilizerNotFoundException(String message) {
        super(message);
    }
}
