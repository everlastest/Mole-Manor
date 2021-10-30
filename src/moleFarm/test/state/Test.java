package moleFarm.test.state;

import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.state.Context;
import moleFarm.pattern.state.conc.InsectDamageWeather;
import moleFarm.pattern.state.conc.RainWeather;

import java.util.HashSet;
import java.util.Set;

public class Test {
    private static MoleFarm farm= MoleAdapter.getInstance().getMoleFarm();

    public static void main(String[] args) {
        MoleFarmBlock block=new MoleFarmBlock();
        Set<FarmBlockStatus>set=new HashSet<>();

        block.setBlockStatusSet(set);
        Context context = new Context(new RainWeather(), farm);
        Context context1=new Context(new InsectDamageWeather(),farm);
        context.watering();
        context1.disinsection();
    }
}
