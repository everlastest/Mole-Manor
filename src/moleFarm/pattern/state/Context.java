package moleFarm.pattern.state;

import moleFarm.Home;
import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.pattern.adapter.Weather;

public class Context {
    /**
     * 当前天气状态
     */
    private Weather weather;


    public Context(Weather weather){
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        System.out.println("当前状态为" + weather);
        this.weather = weather;
    }

    public void watering() {
        weather.watering();
    }

    public void disinsection(){
        weather.disinsection(farmBlock);
    }
}
