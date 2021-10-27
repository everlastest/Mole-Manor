package moleFarm.common;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.product.AbstractFertilizer;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.product.IProduct;
import moleFarm.common.product.crops.*;
import moleFarm.common.product.fertilizer.AdvancedFertilizer;
import moleFarm.common.product.fertilizer.MiddleFertilizer;
import moleFarm.common.product.fertilizer.PrimaryFertilizer;
import moleFarm.common.product.seed.*;
import moleFarm.common.product.tool.*;
import moleFarm.common.repository.IFarmWareHouse;
import moleFarm.pattern.adapter.Mole;
import moleFarm.pattern.adapter.Target;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.chainOfResponsibility.conc.ShopHandler;
import moleFarm.pattern.chainOfResponsibility.conc.WareHouseHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 摩尔个人仓库
 * implements IFarmWareHouse
 */
public class MoleFarmWarehouse implements IFarmWareHouse {
    private Mole mole = Mole.getInstance();
    /**
     * 种子存储
     */
    private Map<AbstractSeed, Integer> seedMap = new HashMap<>();
    /**
     * 肥料存储
     */
    private Map<AbstractFertilizer, Integer> fertilizerMap = new HashMap<>();
    /**
     * 作物存储
     */
    private Map<AbstractCrops, Integer> cropsMap = new HashMap<>();

    private Hoe hoe = Hoe.newInstance();

    private Sickle sickle = Sickle.newInstance();

    private WateringCan wateringCan = WateringCan.newInstance();

    private Pesticide pesticide = Pesticide.newInstance();

    private Shovel shovel = Shovel.newInstance();

    private MoleFarmWarehouse() {
        this.seedMap.put(new CabbageSeed(), 5);
        this.seedMap.put(new EggplantSeed(), 5);
        this.seedMap.put(new RiceSeed(), 5);
        this.seedMap.put(new StrawberrySeed(), 5);
        this.seedMap.put(new WatermelonSeed(), 5);
        this.seedMap.put(new WheatSeed(), 5);
        this.cropsMap.put(new Cabbage(), 3);
        this.cropsMap.put(new Eggplant(), 3);
        this.cropsMap.put(new Rice(), 3);
        this.cropsMap.put(new Strawberry(), 3);
        this.cropsMap.put(new Watermelon(), 3);
        this.cropsMap.put(new Wheat(), 3);
        this.fertilizerMap.put(new AdvancedFertilizer(), 2);
        this.fertilizerMap.put(new MiddleFertilizer(), 2);
        this.fertilizerMap.put(new PrimaryFertilizer(), 2);
    }

    private static volatile MoleFarmWarehouse moleFarmWarehouse = new MoleFarmWarehouse();

    public static synchronized MoleFarmWarehouse getInstance() {
        return moleFarmWarehouse;
    }

    public Hoe getHoe() {
        return hoe;
    }

    public Sickle getSickle() {
        return sickle;
    }

    public WateringCan getWateringCan() {
        return wateringCan;
    }

    public Pesticide getPesticide() {
        return pesticide;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public static MoleFarmWarehouse getMoleFarmWarehouse() {
        return moleFarmWarehouse;
    }

    public Map<AbstractSeed, Integer> getSeedMap() {
        return seedMap;
    }

    public Map<AbstractFertilizer, Integer> getFertilizerMap() {
        return fertilizerMap;
    }

    public Map<AbstractCrops, Integer> getCropsMap() {
        return cropsMap;
    }

    @Override
    public <T extends IProduct> boolean provideItemToMole(List<T> objectList) {
        //调用职责链模式
        WareHouseHandler wareHouseHandler = new WareHouseHandler();
        ShopHandler shopHandler = new ShopHandler();
        wareHouseHandler.setNext(shopHandler);
        return wareHouseHandler.provideSeeds(objectList);
    }

    /**
     * 新增库存
     *
     * @param cropsList
     * @return
     */
    @Override
    public boolean storeToRepository(List<AbstractCrops> cropsList) {
        if (cropsList == null) return false;
        for (AbstractCrops item : cropsList) {
            int num = cropsMap.get(item);
            cropsMap.put(item, num + 1);
        }
        return true;
    }

    public void showRepertory() {
        System.out.println("\n仓库库存如下：");
        System.out.println("白菜\uD83E\uDD66\t茄子\uD83C\uDF46\t水稻\uD83C\uDF3E\t草莓\uD83C\uDF53\t西瓜\uD83C\uDF49\t小麦\uD83C\uDF3F   ");
        System.out.println(cropsMap.get(new Cabbage()) + "\t\t" + cropsMap.get(new Eggplant()) + "\t\t" + cropsMap.get(new Rice()) + "\t\t" +
                cropsMap.get(new Strawberry()) + "\t\t" + cropsMap.get(new Watermelon()) + "\t\t" + cropsMap.get(new Wheat()) + "\t\t");
        System.out.println("白菜种子\t茄子种子\t水稻种子\t草莓种子\t西瓜种子\t小麦种子");
        System.out.println(seedMap.get(new CabbageSeed()) + "\t\t" + seedMap.get(new EggplantSeed()) + "\t\t" + seedMap.get(new RiceSeed()) + "\t\t" +
                seedMap.get(new StrawberrySeed()) + "\t\t" + seedMap.get(new WatermelonSeed()) + "\t\t" + seedMap.get(new WheatSeed()) + "\t\t");
        System.out.println("高级肥料\t中级肥料\t低级肥料");
        System.out.println(fertilizerMap.get(new AdvancedFertilizer()) + "\t\t" + fertilizerMap.get(new MiddleFertilizer()) + "\t\t" +
                fertilizerMap.get(new PrimaryFertilizer()));
    }

    public <T extends IProduct> boolean buyObject(T object, int num, String methodName) {
        Double price = object.getPrice() * num;
        //需要有一个摩尔角色类，判断剩余摩尔豆是否大于等于交换金额，是则返回true，并扣除相应大小的摩尔豆
        //调用适配器
        Target mole = MoleAdapter.getInstance();
        Double money = mole.getMoleDou();
        if (money < price) {
            return false;
        }
        mole.setMoleDou(money - price);
        try {
            Method method = MoleFarmWarehouse.class.getDeclaredMethod(methodName);
            Map<T, Integer> objectMap = (Map<T, Integer>) method.invoke(this);
            Integer orinum = objectMap.putIfAbsent(object, num);
            //若仓库中原本有库存，则将其与新增进货量累加
            if (orinum != null) {
                objectMap.put(object, num + orinum);
            }
            return true;
            //返回仓库中该种子的原有数量，若map中无该类种子，则插入并返回null
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean buySeeds(AbstractSeed seed, int num) {
        if(num<=0){
            System.out.println("请输入正确的数量！");
            return false;
        }
        return buyObject(seed, num, "getSeedMap");
    }

    @Override
    public boolean buyFertilizer(AbstractFertilizer fertilizer, int num) {
        if(num<=0){
            System.out.println("请输入正确的数量！");
            return false;
        }
        return buyObject(fertilizer, num, "getFertilizerMap");
    }

    @Override
    public boolean sellCrops(AbstractCrops crops, int num) {
        if(num<=0){
            System.out.println("请输入正确的数量！");
            return false;
        }
        //计算仓库存量
        int left = this.getCropsMap().get(crops);
        boolean result = left >= num;
        if (result == false) {
            System.out.println("仓库存量不足，卖出失败");
            return false;
        }
        this.getCropsMap().put(crops, left - num);
        mole.setMoney(mole.getMoney() + crops.getPrice() * num);
        System.out.println("卖出成功，共进账" + crops.getPrice() * num + "摩尔豆！" + "当前余额(" + mole.getMoney() + ")");
        return true;
    }

}
