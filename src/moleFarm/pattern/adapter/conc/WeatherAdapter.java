package moleFarm.pattern.adapter.conc;

import MoleMall.MallProcess;
import MoleMall.visitor.ClothesLeaseVisitor;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.product.tool.Pesticide;
import moleFarm.common.product.tool.WateringCan;
import moleFarm.pattern.adapter.Target;
import moleFarm.pattern.adapter.Weather;
import moleFarm.pattern.state.conc.CloudyWeather;
import moleFarm.pattern.state.conc.InsectDamageWeather;
import moleFarm.pattern.state.conc.RainWeather;
import moleFarm.pattern.state.conc.SunnyWeather;

import java.util.Random;

/**
 * 天气适配器
 */
public class WeatherAdapter extends Weather implements Target {

    public static MoleAdapter mole=MoleAdapter.getInstance();

    public static WateringCan wateringCan= mole.getFarmWarehouse().getWateringCan();

    public static Pesticide pesticide= mole.getFarmWarehouse().getPesticide();

    private static WeatherAdapter adapter;
    static
    {
        //随机跳转天气
        Random random = new Random();
        int ran = random.nextInt(4);
        if(ran==0) {
            adapter = new SunnyWeather();
        }else if(ran==1){
            adapter=new RainWeather();
        }else if(ran==2){
            adapter=new InsectDamageWeather();
        }
        else {
            adapter=new CloudyWeather();
        }
    }
    /**
     * 获取天气
     * @return
     */
    @Override
    public String getWeather() {
        return getWeatherStatus();
    }
    public static WeatherAdapter getInstance(){
        return adapter;
    }

    public void watering(MoleFarmBlock farmBlock){}

    public void disInsection(MoleFarmBlock farmBlock){}
}
