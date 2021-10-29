package MoleFarm.pattern.adapter.conc;


//import MoleFarm.pattern.adapter.Mole;

import Framework.SimpleFactory.Mole;
import MoleFarm.common.Home;
import MoleFarm.pattern.adapter.Target;

/**
 * 摩尔角色适配器
 */
public class MoleAdapter extends Mole implements Target {

    private Mole mole= Home.mole;

    private MoleAdapter(){}
    @Override
    public Double getMoleDou() {
        int money = getMoney();
        return Double.valueOf(money);
    }

    @Override
    public void setMoleDou(Double money) {
        mole.setMoney(money.intValue());
    }

    public static MoleAdapter getInstance(){
        return new MoleAdapter();
    }

}
