package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.Weather;
import moleFarm.pattern.iterator.conc.FarmIterator;

import java.util.Set;

public class InsectDamageWeather extends Weather {
    @Override
    public void disinsection(MoleFarmBlock farmBlock) {
        System.out.println("...");
    }
}
