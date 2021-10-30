package moleFarm.pattern.adapter;

import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;

/**
 * 天气类
 */
public abstract class Weather {
    /*
    天气状况
     */
    protected String weatherStatus;

    /**
     * 获取天气状况
     * @return
     */
    public String getWeatherStatus() {
        return weatherStatus;
    }

    public Weather getFarmWeather(){
        return this;
    }

     public void watering(){}

     public void disinsection(){}
}
