package moleFarm.test.chainOfResponsibility;

import moleFarm.common.product.AbstractSeed;
import moleFarm.common.product.seed.EggplantSeed;
import moleFarm.pattern.chainOfResponsibility.conc.ShopHandler;
import moleFarm.pattern.chainOfResponsibility.conc.WareHouseHandler;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<AbstractSeed> list = new ArrayList<>();
        list.add(new EggplantSeed());
        //调用职责链模式
        WareHouseHandler wareHouseHandler = new WareHouseHandler();
        ShopHandler shopHandler = new ShopHandler();
        wareHouseHandler.setNext(shopHandler);
        wareHouseHandler.provideSeeds(list);
    }
}
