package MoleFarm.pattern.adapter.conc;


import MoleFarm.pattern.adapter.Mole;
import MoleFarm.pattern.adapter.Target;

/**
 * 摩尔角色适配器
 */
public class MoleAdapter extends Mole implements Target {

    private MoleAdapter(){}
    @Override
    public Double getMoleDou() {
        return getMoney();
    }

    @Override
    public void setMoleDou(Double money) {
        setMoney(money);
    }

    public static MoleAdapter getInstance(){
        return new MoleAdapter();
    }
}
