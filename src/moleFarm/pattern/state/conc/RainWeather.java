package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.product.tool.WateringCan;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.Weather;
import moleFarm.pattern.iterator.conc.FarmIterator;

import java.util.Set;

public class RainWeather extends Weather {
    @Override
    public void watering(MoleFarmBlock farmBlock) {
        System.out.println("下雨天，不能浇水哦");
    }
}
