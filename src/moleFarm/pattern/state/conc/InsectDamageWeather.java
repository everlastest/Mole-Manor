package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarmBlock;
import moleFarm.common.product.tool.Pesticide;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.conc.WeatherAdapter;

public class InsectDamageWeather extends WeatherAdapter {
    private final String weatherStatus="虫灾";

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
        pesticide.ToolBehavior();
        farmBlock.getBlockStatusSet().removeIf(s->s.equals(FarmBlockStatus.INSECT_DISASTER));
    }
}
