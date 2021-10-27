package MoleFarm.pattern.state;

import MoleFarm.pattern.state.conc.SunnyWeather;

public class Test {
    public static void main(String[] args) {
        Context context = new Context(new SunnyWeather());
        context.watering();
    }
}
