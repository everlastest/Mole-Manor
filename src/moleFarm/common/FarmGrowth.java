package moleFarm.common;

import moleFarm.common.exception.product.conc.CropsNotFoundException;
import moleFarm.common.exception.product.conc.FertilizerNotFoundException;
import moleFarm.common.exception.product.conc.SeedNotFoundException;
import moleFarm.common.product.AbstractCrops;
import moleFarm.common.product.AbstractFertilizer;
import moleFarm.common.product.AbstractSeed;
import moleFarm.common.status.FarmBlockStatus;
import moleFarm.common.status.SeedStatus;
import moleFarm.common.utils.JsonOp;
import moleFarm.pattern.adapter.conc.MoleAdapter;
import moleFarm.pattern.factory.conc.CropsFactory;
import moleFarm.pattern.factory.conc.FertilizerFactory;
import moleFarm.pattern.factory.conc.SeedFactory;
import moleFarm.Home;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FarmGrowth {
    /**
     * 种植方法是一个静态类()有很多静态方法
     */
    private static MoleAdapter mole=MoleAdapter.getInstance();

    private static final SeedFactory seedFactory = Home.seedFactory;

    private static final FertilizerFactory fertilizerFactory = Home.fertilizerFactory;

    private static final CropsFactory cropsFactory = Home.cropsFactory;

    private static final MoleFarmWarehouse moleFarmWarehouse=mole.getFarmWarehouse();

    private static final Map<String, String> map = JsonOp.searchMapper();

    public FarmGrowth() {
    }

    /**
     * 播种
     *
     * @param seed
     */
    public static boolean plantSeed(AbstractSeed seed, MoleFarmBlock farmBlock) {
        if (seed == null) {
            System.out.println("您手上没有种子，无法种植");
            return false;
        } else {
            List<AbstractSeed> seeds = Collections.singletonList(seed);
            //仓库提供种子，调用职责链模式
            if (moleFarmWarehouse.provideItemToMole(seeds)) {
                System.out.println("正在用" + moleFarmWarehouse.getHoe().getName() + "播种" + seed.getName() + "...");
                farmBlock.setSeed(seed);
                //设置生长周期
                farmBlock.setSeedStatus(0);
                return true;
            }
        }
        return false;
    }

    /**
     * 播种
     * 重载
     *
     * @param name
     */
    public static boolean plantSeed(String name, MoleFarmBlock farmBlock) throws SeedNotFoundException {
        AbstractSeed seed = seedFactory.create(map.get(name));
        return plantSeed(seed, farmBlock);
    }

    /**
     * 铲除作物
     */
    public static void eradicateCrops(MoleFarmBlock farmBlock) {
        if (farmBlock.getSeed() != null) {
            moleFarmWarehouse.getShovel().ToolBehavior();
            farmBlock.setSeed(null);
        } else {
            System.out.println("该土地上没有作物，不能铲除");
        }
    }

    /**
     * 松土
     */
    public static void loosenSoil() {
        moleFarmWarehouse.getShovel().ToolBehavior();
    }

    /**
     * 浇水
     */
    public static void watering(MoleFarmBlock farmBlock) {
        //判断是否存在干旱状态，若存在则将其去除
        farmBlock.getBlockStatusSet().removeIf(s -> s.equals(FarmBlockStatus.DROUGHT));
        //使用浇水壶浇水
        moleFarmWarehouse.getWateringCan().ToolBehavior();

    }

    /**
     * 施肥
     *
     * @param fertilizer
     */
    public static void applyFertilizer(AbstractFertilizer fertilizer, MoleFarmBlock farmBlock) {
        if (fertilizer == null) {
            System.out.println("请输入正确的肥料名称噢");
        } else if (farmBlock.getSeed() != null && farmBlock.getSeedStatus() != null && farmBlock.getSeedStatus() < 6) {
            Map<AbstractFertilizer, Integer> fertilizerMap = moleFarmWarehouse.getFertilizerMap();
            int oriNum = fertilizerMap.get(fertilizer);
            if(oriNum<=0){
                System.out.println("抱歉，该肥料暂无库存");
                return;
            }
            System.out.println("正在用" + fertilizer.getName() + "施肥...");
            Integer remainNum = moleFarmWarehouse.getFertilizerMap().get(fertilizer);
            remainNum -= 1;
            //设置新的数量
            moleFarmWarehouse.getFertilizerMap().put(fertilizer, remainNum);
            int status = farmBlock.getSeedStatus();
            Integer integer = fertilizer.fertilizerBehavior(status);
            //设置新的状态
            farmBlock.setSeedStatus(integer);
        }
    }

    /**
     * 施肥(重载)
     *
     * @param name
     */
    public static void applyFertilizer(String name, MoleFarmBlock farmBlock) throws FertilizerNotFoundException {
        AbstractFertilizer fertilizer;
        fertilizer = fertilizerFactory.create(map.get(name));
        applyFertilizer(fertilizer, farmBlock);
    }

    /**
     * 除草
     */
    public static void weed(MoleFarmBlock farmBlock) {
        //若存在杂草状态，则将其删去
        farmBlock.getBlockStatusSet().removeIf(s -> s.equals(FarmBlockStatus.WEEDS));
        //调用镰刀除草
        moleFarmWarehouse.getSickle().ToolBehavior();
    }

    /**
     * 除虫
     */
    public static void disinsection(MoleFarmBlock farmBlock) {
        if (farmBlock.getBlockStatusSet().removeIf(s -> s.equals(FarmBlockStatus.INSECT_DISASTER))) {
            moleFarmWarehouse.getPesticide().ToolBehavior();
        } else {
            System.out.println("农场一片祥和，没有遭遇虫灾");
        }
    }

    /**
     * 收获作物
     *
     * @return
     */
    public static AbstractCrops harvestCrops(MoleFarmBlock farmBlock) {
        if (farmBlock.getSeed() == null) {
            System.out.println("该土地上没有作物，无法收获");
        } else if (farmBlock.getSeedStatus() < 6) {
            System.out.println("作物" + farmBlock.getSeed().getName() + "正处于" +
                    SeedStatus.getSeedStatusByNum(farmBlock.getSeedStatus()).getText() + "期，请过一段时间后再来收获"
            );
        } else {
            String name = farmBlock.getSeed().getName().replace("种子", "");
            farmBlock.setSeed(null);
            try {
                AbstractCrops crops = cropsFactory.create(map.get(name));
                if(crops==null)return crops;
                System.out.println("成功收获一株"+name+"，正在将其运往仓库...");
                Map<AbstractCrops, Integer> cropsMap = moleFarmWarehouse.getCropsMap();
                int oriNum = cropsMap.get(crops);
                cropsMap.put(crops,oriNum+1);
                return crops;
            } catch (CropsNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
