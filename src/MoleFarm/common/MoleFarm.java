package MoleFarm.common;

import MoleFarm.common.exception.MyException;
import MoleFarm.common.exception.product.conc.CropsNotFoundException;
import MoleFarm.common.exception.product.conc.SeedNotFoundException;
import MoleFarm.common.farm.IFarm;
import MoleFarm.common.product.AbstractCrops;
import MoleFarm.common.product.AbstractSeed;
import MoleFarm.common.status.product.Shape;
import MoleFarm.common.utils.JsonOp;
import MoleFarm.pattern.factory.conc.CropsFactory;
import MoleFarm.pattern.iterator.conc.FarmIterator;

import java.util.*;

/**
 * 摩尔个人农场
 * implements IFarm
 */
public class MoleFarm implements IFarm {
    private static final Map<String, String> mapJson = JsonOp.searchMapper();
    /**
     * 农田块数量
     */
    private Integer farmBlockCount = 9;
    /**
     * 形状
     */
    private Shape shape = Shape.CIRCULAR;
    /**
     * 面积
     */
    private Integer area = 1;
    /**
     * 农田块列表
     */
    private List<MoleFarmBlock> farmBlockList;

    private static volatile MoleFarm moleFarm = new MoleFarm();

    public static synchronized MoleFarm getInstance() {
        return moleFarm;
    }

    private MoleFarm() {
        farmBlockList = new ArrayList<>();
        for (int i = 0; i < farmBlockCount; ++i) {
            farmBlockList.add(new MoleFarmBlock());
        }
    }

    /**
     * 迭代器
     *
     * @return
     */
    public FarmIterator getIterator() {
        return (new FarmIterator(farmBlockList));
    }

    /**
     * 种下种子
     * 批量操作
     *
     * @param seed
     * @throws MyException
     */
    @Override
    public void plantBatchSeeds(AbstractSeed seed) {
        //寻找空地，一键播种
        for (MoleFarmBlock item : farmBlockList) {
            if (item.getSeed() != null) {
                FarmGrowth.plantSeed(seed, item);
            }
        }
        System.out.println("所有空地均已播种成功");
//        if (seedList.size() > farmBlockList.size())
//            throw new MyException("作物数量太多，无法种植");
    }

    /**
     * 种下种子(重载)
     * 批量操作
     *
     * @param name
     * @throws MyException
     */
    public void plantBatchSeeds(String name) throws SeedNotFoundException {
        //寻找空地，一键播种
        for (MoleFarmBlock item : farmBlockList) {
            if (item.getSeed() == null) {
                if (!FarmGrowth.plantSeed(name, item)) break;
            }
        }
        System.out.println("批量播种结束");
//        if (seedList.size() > farmBlockList.size())
//            throw new MyException("作物数量太多，无法种植");
    }

    @Override
    public void plantSeeds(AbstractSeed seed) {

    }

    /**
     * 收获作物
     * 批量操作
     *
     * @return
     */
    @Override
    public List<AbstractCrops> harvestCrops() {
        List<AbstractCrops> cropsList = new ArrayList<>();
        for (MoleFarmBlock item : farmBlockList) {
            AbstractCrops crops = null;
            if (item.getSeedStatus() != null && item.getSeedStatus() >= 6) {
                String name = item.getSeed().getName().replace("种子","");
                item.setSeed(null);
                CropsFactory cropsFactory = CropsFactory.newInstance();
                try {
                    crops = cropsFactory.create(mapJson.get(name));
                } catch (CropsNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (crops != null) {
                cropsList.add(crops);
            }
        }
        if (cropsList.size()==0) {
            System.out.println("抱歉，暂无成熟作物可收获");
            return null;
        } else {
            Map<AbstractCrops, Integer> map = new HashMap<>();
            for (AbstractCrops crop : cropsList) {
                int num = map.get(crop) == null ? 0 : map.get(crop);
                map.put(crop, num + 1);
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                AbstractCrops key = (AbstractCrops) entry.getKey();
                Integer value = (Integer) entry.getValue();
                System.out.println("共收获" + key.getName() + "数量：" + value);
            }
        }
        return cropsList;
    }

    /**
     * 展示农场
     */
    public void showFarm() {
        System.out.println("\n农田状态如下：");
        for (int i = 0; i < farmBlockList.size(); i += 3) {
            System.out.print(farmBlockList.get(i).getSeed() == null ? "┏━┓" : "┎┰┒");
            System.out.print(farmBlockList.get(i + 1).getSeed() == null ? "┏━┓" : "┎┰┒");
            System.out.print(farmBlockList.get(i + 2).getSeed() == null ? "┏━┓" : "┎┰┒");
            System.out.println(" ");
            System.out.print(farmBlockList.get(i).getSeed() == null ? "┗━┛" : "┖┸┚");
            System.out.print(farmBlockList.get(i + 1).getSeed() == null ? "┗━┛" : "┖┸┚");
            System.out.print(farmBlockList.get(i + 2).getSeed() == null ? "┗━┛" : "┖┸┚");
            System.out.println(i == 0 ? "①~③" : i == 3 ? "④~⑥" : "⑦~⑨");
        }
    }
}
