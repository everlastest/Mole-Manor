package moleFarm.test.factory;

import com.alibaba.fastjson.JSONObject;
import moleFarm.Home;
import moleFarm.common.exception.product.conc.CropsNotFoundException;
import moleFarm.common.exception.product.conc.SeedNotFoundException;
import moleFarm.common.product.AbstractCrops;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.utils.JsonOp;
import moleFarm.pattern.factory.conc.CropsFactory;
import moleFarm.pattern.factory.conc.SeedFactory;

import java.util.Map;

public class Test {
    private static Map<String,String> map= JsonOp.searchMapper();

    private static SeedFactory seedFactory=SeedFactory.newInstance();

    private static CropsFactory cropsFactory=CropsFactory.newInstance();

    private static void produceSeed(String seedName){
        String name=map.get(seedName);
        try {
            AbstractSeed seed = seedFactory.create(name);
            System.out.println("种子工厂正在生产"+seedName+"...");
            System.out.println("种子名称："+seed.getName());
            System.out.println("种子价格："+seed.getPrice());
            System.out.println("种子颜色："+seed.getColor());
            System.out.println("种子生产周期"+seed.getGrowthCycle());
        } catch (SeedNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("-------------------------");
        }
    }

    private static void produceCrops(String cropsName){
        String name=map.get(cropsName);
        try {
            AbstractCrops crops = cropsFactory.create(name);
            System.out.println("种子工厂正在生产"+cropsName+"...");
            System.out.println("作物名称："+crops.getName());
            System.out.println("作物价格："+crops.getPrice());
            System.out.println("作物颜色："+crops.getColor());
        } catch (CropsNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        String seedName="草莓种子";

        produceSeed(seedName);

        String cropsName="西瓜";

        produceCrops(cropsName);
    }
}
