package MoleFarm.pattern.state;

import MoleFarm.MoleFarm;

public class Context {
    private Weather weather;

    private MoleFarm moleFarm = MoleFarm.getInstance();


    public Context(Weather weather) {
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

    public void disinsection() {
        weather.disinsection(moleFarm);
    }
}
