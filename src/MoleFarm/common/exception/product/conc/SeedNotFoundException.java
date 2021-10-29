package MoleFarm.common.exception.product.conc;

import MoleFarm.common.exception.product.ProductNotFoundException;

public class SeedNotFoundException extends ProductNotFoundException {
    public SeedNotFoundException(String message) {
        super(message);
    }
}
