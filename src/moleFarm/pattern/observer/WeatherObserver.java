package moleFarm.pattern.observer;

import moleFarm.common.MoleFarm;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.pattern.adapter.conc.WeatherAdapter;
import moleFarm.pattern.iterator.conc.FarmIterator;

import java.util.Set;

/**
 * 天气状态
 */
public class WeatherObserver {
    private MoleFarm moleFarm = MoleFarm.getInstance();
    private WeatherObserver(){}
    public static WeatherObserver getInstance(){
        return new WeatherObserver();
    }

    /**
     * 观察天气
     */
    public void observer(WeatherAdapter weatherAdapter) {
        if ("雨天".equals(weatherAdapter.getWeather())) {
            //下雨天去除干旱状态
            FarmIterator iterator = moleFarm.getIterator();
            while (iterator.hasNext()) {
                Set<FarmBlockStatus> statusList = iterator.next().getBlockStatusSet();
                statusList.remove(FarmBlockStatus.DROUGHT);
            }
        }
    }

}
