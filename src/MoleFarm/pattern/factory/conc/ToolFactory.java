package MoleFarm.pattern.factory.conc;

import MoleFarm.common.MoleFarmWarehouse;
import MoleFarm.common.exception.product.conc.ToolNotFoundException;
import MoleFarm.common.product.AbstractTool;
import MoleFarm.common.utils.JsonOp;
import MoleFarm.pattern.factory.Factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 工具的抽象工厂类，此处不再写具体的，如ConcreteFarmToolFactory
 */
public class ToolFactory implements Factory {
    private final static String PATH = JsonOp.getPathJson("ToolFactory");
    private final static String MSG = JsonOp.getMsgJson("ToolFactory");
    private static volatile ToolFactory toolFactory;

    private ToolFactory() {
    }

    public synchronized static ToolFactory newInstance() {
        if (toolFactory == null) {
            toolFactory = new ToolFactory();
        }
        return toolFactory;
    }

    @Override
    public AbstractTool create(String name) throws ToolNotFoundException {
        try {
            Method method = MoleFarmWarehouse.class.getDeclaredMethod("get" + name);
            final MoleFarmWarehouse moleFarmWarehouse = MoleFarmWarehouse.getMoleFarmWarehouse();
            AbstractTool invoke = (AbstractTool) method.invoke(moleFarmWarehouse);
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ToolNotFoundException(MSG);
        }
    }
}
