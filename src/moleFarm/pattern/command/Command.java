package moleFarm.pattern.command;

import moleFarm.common.product.IProduct;

/**
 * 抽象命令
 */
public interface Command {
    public boolean execute(String name, int num);
}
