package MoleFarm.common.exception.product.conc;

import MoleFarm.common.exception.product.ProductNotFoundException;

public class ToolNotFoundException extends ProductNotFoundException {

    public ToolNotFoundException(String message) {
        super(message);
    }
}
