package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.iterator.conc.FarmIterator;
import moleFarm.pattern.state.Weather;

import java.util.Set;

public class InsectDamageWeather implements Weather {
    @Override
    public void disinsection(MoleFarm moleFarm) {
        FarmIterator iterator=moleFarm.getIterator();
        MoleFarmBlock first = iterator.first();
        while(iterator.hasNext()){
            MoleFarmBlock next = iterator.next();
            Set<FarmBlockStatus> set = next.getBlockStatusSet();
            //如果存在虫灾状态就删除
            set.removeIf(s->s.equals(FarmBlockStatus.INSECT_DISASTER));
        }
    }
}
