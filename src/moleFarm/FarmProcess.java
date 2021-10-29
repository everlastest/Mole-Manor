package moleFarm;

import moleFarm.common.Shop;
import moleFarm.common.exception.product.ProductNotFoundException;
import moleFarm.common.exception.product.conc.CropsNotFoundException;
import moleFarm.common.exception.product.conc.FertilizerNotFoundException;
import moleFarm.common.exception.product.conc.SeedNotFoundException;
import moleFarm.common.FarmGrowth;
import moleFarm.common.MoleFarm;
import moleFarm.common.MoleFarmBlock;
import moleFarm.common.product.AbstractFertilizer;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.product.IProduct;
import moleFarm.common.MoleFarmWarehouse;
import moleFarm.common.utils.JsonOp;

import Framework.SimpleFactory.Mole;
import moleFarm.pattern.adapter.conc.WeatherAdapter;
import moleFarm.pattern.builder.Director;
import moleFarm.pattern.builder.conc.ConcreteBuilder1;
import moleFarm.pattern.builder.conc.ConcreteBuilder2;
import moleFarm.pattern.factory.Factory;
import moleFarm.pattern.factory.conc.CropsFactory;
import moleFarm.pattern.factory.conc.FertilizerFactory;
import moleFarm.pattern.factory.conc.SeedFactory;
import moleFarm.pattern.iterator.conc.FarmIterator;

import java.util.Map;
import java.util.Scanner;

/**
 * 农场主进程
 */
public class FarmProcess {
    /*
    农田
     */
    private MoleFarm farm = Home.farm;
    //仓库
    private MoleFarmWarehouse warehouse = Home.farmWarehouse;
    /*
    摩尔角色
     */
    private Mole mole = Home.mole;
    /*
        商店
         */
    private Shop shop = Home.shop;
    /*
    具体工厂，负责生产种子/作物/肥料
     */
    private final SeedFactory seedFactory = Home.seedFactory;
    private final CropsFactory cropFactory = Home.cropsFactory;
    private final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;
    /*
    Map<String,String>，负责将product的中英文名对应
     */
    private final Map<String, String> map = JsonOp.searchMapper();

    private FarmProcess() {
    }

    private static volatile FarmProcess farmProcess = new FarmProcess();

    public static synchronized FarmProcess newInstance() {
        return farmProcess;
    }

    public void farmSmallProcess(String str3, MoleFarmBlock block) {
        Scanner input = new Scanner(System.in);
        switch (str3) {
            case "1":
                if (block.getSeed() == null) {
                    System.out.println("请输入想要种植的作物种子:(白菜/茄子/水稻/草莓/西瓜/小麦种子）");
                    String seedName = input.next();
                    System.out.println("请输入1选择普通种植，输入2选择一键种植(种植+初级肥料)，输入3选择超级一键种植(松土+种植+浇水+除草+高级肥料)");
                    String way = input.next();
                    try {
                        switch (way) {
                            case "1":
                                FarmGrowth.plantSeed(seedName, block);
                                break;
                            case "2":
                                //调用建造者模式
                                ConcreteBuilder2 concreteBuilder2 = new ConcreteBuilder2();
                                concreteBuilder2.setFarmBlock(block);
                                Director director = new Director(concreteBuilder2, block);
                                director.getMoleFarmBlock(seedFactory.create(map.get(seedName)));
                                break;
                            case "3":
                                ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
                                concreteBuilder1.setFarmBlock(block);
                                Director director1 = new Director(concreteBuilder1, block);
                                director1.getMoleFarmBlock(seedFactory.create(map.get(seedName)));
                                break;
                        }
                    } catch (SeedNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("该土地上已有种子，无法继续种植");
                }
                break;
            case "2":
                //收获
                FarmGrowth.harvestCrops(block);
                break;
            case "3":
                //浇水
                FarmGrowth.watering(block);
                break;
            case "4":
                //除草
                FarmGrowth.weed(block);
                break;
            case "5":
                //除虫
                FarmGrowth.disinsection(block);
                break;
            case "6":
                //施肥
                if (block.getSeed() == null) {
                    System.out.println("此处没有种子种植，播种后再施肥效果更佳噢");
                } else if (block.getSeedStatus() == 6 || block.getSeedStatus() == 7) {
                    System.out.println("作物已经成熟，请立即收获");
                } else {
                    try {
                        System.out.println("请选择肥料：高级肥料(库存：" + warehouse.getFertilizerMap().get(fertilizerFactory.create(
                                "AdvancedFertilizer")) + ")，中级肥料(库存：" + warehouse.getFertilizerMap().get(fertilizerFactory.create(
                                "MiddleFertilizer")) + ")，初级肥料(库存：" + warehouse.getFertilizerMap().get(fertilizerFactory.create(
                                "PrimaryFertilizer")) + ")");
                        String fertilizerName = input.next();
                        FarmGrowth.applyFertilizer(fertilizerName, block);
                    } catch (FertilizerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case "7":
                //铲除作物
                FarmGrowth.eradicateCrops(block);
                break;
            default:
                return;
        }
    }

    /**
     * 农田进程
     *
     * @param str2
     */
    public void farmProcess(String str2) {
        Scanner input = new Scanner(System.in);
        boolean sign = true;
        while (true) {
            //批量操作
            if ("b".equals(str2)) {
                System.out.println("\n批量操作");
                System.out.println("请输入1选择批量播种，2选择批量收获，0返回上级：");
                String str3 = input.next();
                if ("1".equals(str3)) {
                    System.out.println("请输入想要种植的作物种子");
                    String name = input.next();
                    try {
                        farm.plantBatchSeeds(name);
                    } catch (ProductNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if ("2".equals(str3)) {
                    //批量收获作物并放入仓库
                    if (warehouse.storeToRepository(farm.harvestBatchSeeds())) {
                        System.out.println("已为您批量收获作物并放入仓库");
                    }
                } else {
                    break;
                }
            }
            //单个农田块操作
            else {
                //获取农田块编号
                int index = Integer.parseInt(str2) - 1;
                //获取具体农田块对象
                FarmIterator iterator = farm.getIterator();
                MoleFarmBlock block = iterator.getByIndex(index);
                if (sign) {
                    block.addStatus();
                    sign = false;
                    if (block.getSeed() != null && block.getSeedStatus() != null) {
                        //作物随机生长
                        block.growth();
                    }
                }
                //控制台输出农田块信息
                block.getInfo();
                System.out.println("请选择：0——返回上级，1——种植作物，2——收获作物，3——浇水，4——除草，5——除虫，6——施肥，7——铲除作物");
                String str3 = input.next();
                if ("0".equals(str3)) {
                    break;
                }
                //对作物进行具体操作
                farmSmallProcess(str3, block);
            }
        }
    }

    private <T extends Factory> void warehouseSmallProcess(String objName, String name, T factory) {
        try {
            Scanner input = new Scanner(System.in);
            String objClassName = map.get(objName);
            IProduct obj = factory.create(objClassName);
            System.out.println("请输入想要购买的" + name + "数目(您现在有" + mole.getMoney() + "摩尔豆):");
            int objNum = input.nextInt();
            Double price = objNum * obj.getPrice();
            if (obj instanceof AbstractSeed) {
                if (shop.buySeeds((AbstractSeed) obj, objNum)) {
                    System.out.println("正在向商店购买" + obj.getName() +
                            "，共消费" + price + "摩尔豆，" +
                            "剩余" + mole.getMoney() + "摩尔豆\n");
                } else {
                    System.out.println("抱歉你的摩尔豆不足");
                }
            } else {
                if (shop.buyFertilizer((AbstractFertilizer) obj, objNum)) {
                    System.out.println("正在向商店购买" + obj.getName() +
                            "，共消费" + price + "摩尔豆，" +
                            "剩余" + mole.getMoney() + "摩尔豆\n");
                } else {
                    System.out.println("抱歉你的摩尔豆不足\n");
                }
            }
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 仓库进程
     *
     * @param str4
     */
    public void warehouseProcess(String str4) {
        Scanner input = new Scanner(System.in);
        while (true) {
            switch (str4) {
                case "1":
                    String text1 = "种子";
                    System.out.println("请输入想要购买的" + text1 + "类型" +
                            "(白菜种子--3.0，茄子种子--5.0，水稻种子--2.0，草莓种子--6.0，西瓜种子--5.0，小麦种子--3.0)，" +
                            "输入0返回上级：");
                    String objName = input.next();
                    if ("0".equals(objName)) {
                        return;
                    }
                    //挑选种类，输入数目，买入种子
                    warehouseSmallProcess(objName, text1, seedFactory);
                    break;
                case "2":
                    String text2 = "肥料";
                    System.out.println("请输入想要购买的" + text2 + "类型" +
                            "(高级肥料--10.0，中级肥料--5.0，初级肥料--2.0)，" +
                            "输入0返回上级：");
                    String objName1 = input.next();
                    if ("0".equals(objName1)) {
                        return;
                    }
                    warehouseSmallProcess(objName1, text2, fertilizerFactory);
                    break;
                case "3":
                    //挑选种类，输入数目，卖出作物
                    System.out.println("请输入想要卖出的作物类型" +
                            "(白菜--10.0，茄子--20.0，水稻--4.0，草莓--30.0，西瓜--20.0，小麦--5.0)"
                            + "，输入0返回上级：");
                    String cropName = input.next();
                    if (cropName.equals("0")) {
                        return;
                    }
                    String cropClassName = map.get(cropName);
                    System.out.println("请输入想要卖出的作物数目：");
                    int cropNum = input.nextInt();
                    try {
                        shop.sellCrops(cropFactory.create(cropClassName), cropNum);
                    } catch (CropsNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * 农场主函数
     */
    public void process() {
        System.out.println("输入y进入农场：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        //获取今日天气并输出
        WeatherAdapter weatherAdapter = WeatherAdapter.getInstance();
        weatherAdapter.transfer();
        while (!"0".equals(str)) {
            //欢迎辞
            System.out.print("\n欢迎来到欢乐农场！\n" +
                    "今日天气：");
            System.out.print(weatherAdapter.getWeather() + "\n");
            System.out.println("请选择您要去的地方：1——农田，2——仓库，0——游戏首页");
            String str1 = input.next();
            //农田模块
            while ("1".equals(str1)) {
                //绘制农田状态图
                farm.showFarm();
                System.out.println("请输入1~9查看具体农田块状态，输入0返回农场首页，输入b选择批量操作：");
                String str2 = input.next();
                if ("0".equals(str2)) {
                    break;
                }
                farmProcess(str2);
            }
            //仓库模块
            while ("2".equals(str1)) {
                warehouse.showRepertory();
                System.out.println("请选择操作：0——返回农场首页，1——买入种子，2——买入肥料，3——卖出作物");
                String str4 = input.next();
                if ("0".equals(str4)) {
                    break;
                }
                warehouseProcess(str4);
            }
        }
    }
}
