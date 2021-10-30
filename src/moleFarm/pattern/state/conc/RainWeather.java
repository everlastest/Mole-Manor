package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarmBlock;
import moleFarm.pattern.adapter.conc.WeatherAdapter;

public class RainWeather extends WeatherAdapter {
    private final String weatherStatus="雨天";

    @Override
    public String getWeather() {
        return weatherStatus;
    }

    @Override
    public void watering(MoleFarmBlock farmBlock) {
        System.out.println("下雨天，再浇水可就gg了...");
    }

    @Override
    public void disInsection(MoleFarmBlock farmBlock) {
        System.out.println("农场一片祥和，没有遭遇虫灾");
    }
}
