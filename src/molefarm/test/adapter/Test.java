package molefarm.test.adapter;

import framework.simplefactory.Mole;
import molefarm.common.MoleFarmBlock;
import molefarm.pattern.adapter.conc.MoleAdapter;
import molefarm.pattern.adapter.conc.WeatherAdapter;

public class Test {
    //测试天气适配器
    public void WeatherTest(){
        WeatherAdapter weatherAdapter = WeatherAdapter.getInstance();
        //随机跳转天气
        weatherAdapter.changeWeather();
        //获取天气
        weatherAdapter.getWeather();
        MoleFarmBlock moleFarmBlock = new MoleFarmBlock();
        //测试除虫方法
        weatherAdapter.disInsection(moleFarmBlock);
        //测试浇水方法
        weatherAdapter.watering(moleFarmBlock);
    }
    public void MoleAdapterTest(){
        Mole mole = new Mole();
        MoleAdapter moleAdapter = MoleAdapter.getInstance();
        moleAdapter.getMole();
        moleAdapter.getMoleDou();
        moleAdapter.getFarmWarehouse();
        moleAdapter.getMoleFarm();
        moleAdapter.setMoleDou(1000.0);
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.MoleAdapterTest();
        test.MoleAdapterTest();
    }
}
