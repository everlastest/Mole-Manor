package moleFarm.common.exception.product.conc;

import moleFarm.common.exception.product.ProductNotFoundException;

public class ToolNotFoundException extends ProductNotFoundException {

    public ToolNotFoundException(String message) {
        super(message);
    }
}
