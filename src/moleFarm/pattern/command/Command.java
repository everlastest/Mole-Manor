package moleFarm.pattern.command;

import moleFarm.common.product.IProduct;

/**
 * 抽象命令
 */
public interface Command {
    boolean execute(IProduct product, int num);
}
