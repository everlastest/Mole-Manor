package moleFarm.test.observer;

import moleFarm.pattern.adapter.conc.WeatherAdapter;
import moleFarm.pattern.observer.WeatherObserver;

public class Test {
    public static void main(String[] args) {
        WeatherAdapter weatherAdapter = WeatherAdapter.getInstance();
        WeatherObserver weatherobserver = WeatherObserver.getInstance();
        weatherobserver.observer(weatherAdapter);
    }
}
