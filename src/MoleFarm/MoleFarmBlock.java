package MoleFarm;

import MoleFarm.common.product.AbstractCrops;
import MoleFarm.common.product.AbstractSeed;
import MoleFarm.common.status.FarmBlockStatus;
import MoleFarm.common.status.SeedStatus;
import MoleFarm.common.status.product.Shape;

import java.util.LinkedHashSet;
import java.util.Set;

public class MoleFarmBlock implements IFarmBlock {
    /**
     * 形状
     */
    private final Shape shape = Shape.CIRCULAR;
    /**
     * 面积
     */
    private final Double area = 1.0;
    /**
     * 种子
     */
    private AbstractSeed seed;
    /**
     * 种子状态
     * 这里调用 SeedStatus.getSeedStatusByNum(int number)
     * 获取农田状态
     */
    private Integer seedStatus;
    /**
     * 农田块状态列表
     */
    private Set<FarmBlockStatus> statusList = new LinkedHashSet<>();


    public Shape getShape() {
        return shape;
    }

    public Double getArea() {
        return area;
    }

    public AbstractSeed getSeed() {
        return seed;
    }

    public void setSeed(AbstractSeed seed) {
        this.seed = seed;
    }

    public Integer getSeedStatus() {
        return seedStatus;
    }

    public void setSeedStatus(Integer seedStatus) {
        this.seedStatus = seedStatus;
    }

    public Set<FarmBlockStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(Set<FarmBlockStatus> statusList) {
        this.statusList = statusList;
    }


    @Override
    public void plantSeed(AbstractSeed seed) {

    }

    @Override
    public AbstractCrops harvestCrops() {
        return null;
    }

    /**
     * 作物生长方法
     * 采用随机方法
     */
    public void growth() {
        //随机增加生长周期(0~2)
        Double growth = Math.floor(Math.random() * 3);
        Integer seedStatus = getSeedStatus() + growth.intValue();
        setSeedStatus(seedStatus > 7 ? 7 : seedStatus);
    }

    /**
     * 增加农田状态
     * 随机
     */
    public void addStatus() {
        //0~2随机增加状态，3不增加异常状态
        Double random = Math.floor(Math.random() * 3);
        FarmBlockStatus value = FarmBlockStatus.values()[random.intValue()];
        statusList.add(value);
//        for (FarmBlockStatus value : FarmBlockStatus.values()) {
//            if (random.intValue() == value.ordinal()) {
//                if (!statusList.contains(value)) statusList.add(value);
//            }
//        }
    }

    /**
     * 获取农田块信息
     */
    public void getInfo() {
        String seedInfo = seed == null ? "抱歉，该农田块上暂未种植作物" : ("作物：" + seed.getName());
        StringBuilder statusInfo = new StringBuilder("状态：");
        StringBuilder growthInfo = new StringBuilder("生长周期：");
        if (statusList == null || statusList.size() == 0) {
            statusInfo.append("正常");
        } else {
            for (FarmBlockStatus i : statusList) {
                statusInfo.append(i.getText()).append("  ");
            }
        }
        if (seed != null && seedStatus != null) {
            growthInfo.append(SeedStatus.getSeedStatusByNum(seedStatus).getText()).append("期");
        }
        System.out.println(seedInfo);
        System.out.println(statusInfo);
        System.out.println(growthInfo);
    }
}
