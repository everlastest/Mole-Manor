package moleFarm.pattern.state.conc;

import moleFarm.common.MoleFarmBlock;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.conc.WeatherAdapter;

import java.util.Set;

public class CloudyWeather extends WeatherAdapter {
    private final String weatherStatus="阴天";

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
        Set<FarmBlockStatus> blockStatusSet = farmBlock.getBlockStatusSet();
        if(blockStatusSet.contains(FarmBlockStatus.DROUGHT)) {
            pesticide.ToolBehavior();
            blockStatusSet.remove(FarmBlockStatus.INSECT_DISASTER);
        }
        else{
            System.out.println("农场一片祥和，没有遭遇虫灾");
        }
    }
}
