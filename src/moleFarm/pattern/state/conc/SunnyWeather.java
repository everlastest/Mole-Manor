package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.conc.WeatherAdapter;

public class SunnyWeather extends WeatherAdapter {
    private final String weatherStatus="晴天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(MoleFarmBlock farmBlock) {
        wateringCan.ToolBehavior();
        farmBlock.getBlockStatusSet().removeIf((s)->s.equals(FarmBlockStatus.DROUGHT));
    }

    @Override
    public void disInsection(MoleFarmBlock farmBlock) {
        System.out.println("农场一片祥和，没有遭遇虫灾");
    }
}
