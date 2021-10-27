package moleFarm.common.exception.product.conc;

import moleFarm.common.exception.product.ProductNotFoundException;

public class FertilizerNotFoundException extends ProductNotFoundException {
    public FertilizerNotFoundException(String message) {
        super(message);
    }
}
