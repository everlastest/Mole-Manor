package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.iterator.conc.FarmIterator;
import moleFarm.pattern.state.Weather;

import java.util.Set;

public class RainWeather implements Weather {
    @Override
    public void watering(MoleFarm moleFarm) {
        FarmIterator iterator = moleFarm.getIterator();
        while (iterator.hasNext()) {
            MoleFarmBlock next = iterator.next();
            Set<FarmBlockStatus> set= next.getBlockStatusSet();
            //如果存在干旱状态，就把它去掉
            set.removeIf(s -> s.equals(FarmBlockStatus.DROUGHT));
        }
    }

    @Override
    public void disinsection(MoleFarm moleFarm) {

    }
}
