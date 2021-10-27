package MoleFarm.pattern.adapter.conc;


//import MoleFarm.pattern.adapter.Mole;
import MoleFarm.pattern.adapter.Target;
import SimpleFactory.Mole;
import Singleton_LazyInitialization.MoleManor;

/**
 * 摩尔角色适配器
 */
public class MoleAdapter extends Mole implements Target {

    private Mole mole= MoleManor.getInstance().getPlayer();

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
