package molefarm.test.observer;

import molefarm.pattern.adapter.conc.WeatherAdapter;
import molefarm.pattern.observer.WeatherObserver;

public class Test {
    public static void main(String[] args) {
        WeatherAdapter weatherAdapter = WeatherAdapter.getInstance();
        WeatherObserver weatherobserver = WeatherObserver.getInstance();
        weatherobserver.observer(weatherAdapter);
    }
}
