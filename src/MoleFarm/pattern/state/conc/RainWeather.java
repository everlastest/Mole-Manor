package MoleFarm.pattern.state.conc;

import MoleFarm.MoleFarm;
import MoleFarm.MoleFarmBlock;
import MoleFarm.common.status.FarmBlockStatus;
import MoleFarm.pattern.iterator.conc.FarmIterator;
import MoleFarm.pattern.state.Weather;

import java.util.Set;

public class RainWeather implements Weather {
    @Override
    public void watering(MoleFarm moleFarm) {
        FarmIterator iterator = moleFarm.getIterator();
        while (iterator.hasNext()) {
            MoleFarmBlock next = iterator.next();
            Set<FarmBlockStatus> statusList = next.getStatusList();
            //如果存在干旱状态，就把它去掉
            statusList.removeIf(s -> s.equals(FarmBlockStatus.DROUGHT));
        }
    }

    @Override
    public void disinsection(MoleFarm moleFarm) {

    }
}
