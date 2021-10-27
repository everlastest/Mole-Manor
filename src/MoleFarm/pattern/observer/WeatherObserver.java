package MoleFarm.pattern.observer;

import MoleFarm.MoleFarm;
import MoleFarm.common.status.FarmBlockStatus;
import MoleFarm.pattern.adapter.conc.WeatherAdapter;
import MoleFarm.pattern.iterator.conc.FarmIterator;

import java.util.Set;

/**
 * 天气状态
 */
public class WeatherObserver {
    private MoleFarm moleFarm;
    private WeatherAdapter weatherAdapter;

    /**
     * 构造函数
     *
     * @param farm
     */
    public WeatherObserver(MoleFarm farm) {
        this.moleFarm = farm;
    }

    /**
     * 观察天气
     */
    public void observer() {
        weatherAdapter = WeatherAdapter.getInstance();
        if (weatherAdapter.getWeather().equals("雨天")) {
            //下雨天去除干旱状态
            FarmIterator iterator = moleFarm.getIterator();
            while (iterator.hasNext()) {
                Set<FarmBlockStatus> statusList = iterator.next().getStatusList();
                statusList.remove(FarmBlockStatus.DROUGHT);
            }
        }
    }

}
