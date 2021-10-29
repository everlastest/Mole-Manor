package moleFarm.common.exception.product.conc;

import moleFarm.common.exception.product.ProductNotFoundException;

public class SeedNotFoundException extends ProductNotFoundException {
    public SeedNotFoundException(String message) {
        super(message);
    }
}
