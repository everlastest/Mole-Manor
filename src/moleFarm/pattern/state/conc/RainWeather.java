package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.conc.WeatherAdapter;

import java.util.Set;

public class RainWeather extends WeatherAdapter {
    private final String weatherStatus="雨天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(MoleFarmBlock farmBlock) {
        System.out.println("下雨天还敢浇水，不怕烂根么！！！");
    }

    @Override
    public void disInsection(MoleFarmBlock farmBlock) {
        Set<FarmBlockStatus> blockStatusSet = farmBlock.getBlockStatusSet();
        if(blockStatusSet.removeIf(s->s.equals(FarmBlockStatus.INSECT_DISASTER))) {
            pesticide.ToolBehavior();
        }
        else{
            System.out.println("农场一片祥和，没有遭遇虫灾");
        }
    }
}
