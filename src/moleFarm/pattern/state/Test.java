package moleFarm.pattern.state;

import moleFarm.pattern.state.conc.SunnyWeather;

public class Test {
    public static void main(String[] args) {
        Context context = new Context(new SunnyWeather());
        context.watering();
    }
}
