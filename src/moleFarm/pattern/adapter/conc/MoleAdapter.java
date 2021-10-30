package moleFarm.pattern.adapter.conc;


//import moleFarm.pattern.adapter.Mole;

import Framework.SimpleFactory.Mole;
import Singleton_LazyInitialization.MoleManor;
import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.pattern.adapter.Target;

/**
 * 摩尔角色适配器
 * 这里采用了单例模式(因为只有一个mole)
 */
public class MoleAdapter extends Mole implements Target {

    private static MoleAdapter moleAdapter=new MoleAdapter(MoleManor.getPlayer());
    //这个mole对象要从外界传进来的，因为这是适配器
    private Mole mole;

    private MoleFarm moleFarm=MoleFarm.getInstance();

    private MoleFarmWarehouse farmWarehouse=MoleFarmWarehouse.getInstance(moleAdapter);

    private MoleAdapter(Mole mole){
        this.mole=mole;
    }

    //返回mole适配器对象实例
    public static MoleAdapter getInstance(){
        return moleAdapter;
    }

    @Override
    public Double getMoleDou() {
        return getMoney();
    }

    @Override
    public void setMoleDou(Double money) {
        mole.setMoney(money);
    }

    public Mole getMole() {
        return mole;
    }

    public MoleFarm getMoleFarm() {
        return moleFarm;
    }

    public MoleFarmWarehouse getFarmWarehouse() {
        return farmWarehouse;
    }
}
