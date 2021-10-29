package moleFarm.pattern.state;

import moleFarm.Home;
import moleFarm.common.MoleFarm;

public class Context {
    /**
     * 当前天气状态
     */
    private Weather weather;

    private MoleFarm moleFarm;

    public Context(Weather weather,MoleFarm moleFarm) {
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
        weather.watering(moleFarm);
    }

    public void disinsection(){
        weather.disinsection(moleFarm);
    }
}
