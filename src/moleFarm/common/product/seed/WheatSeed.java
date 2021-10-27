package moleFarm.common.product.seed;

import moleFarm.common.product.AbstractSeed;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 小麦种子
 */
public class WheatSeed extends AbstractSeed implements Cloneable {
    /**
     * 名字
     */
    private final String name = "小麦种子";
    /**
     * 颜色
     */
    private final Color color = Color.BROWN;
    /**
     * 大小
     */
    private final Size size = Size.SMALL;
    /**
     * 生长周期
     */
    private final String growthCycle = "100天";
    /**
     * 价格
     */
    private final Double price = 3.0;

    public WheatSeed() {
    }

    /**
     * 构造方法
     *
     * @param name
     * @param color
     * @param size
     * @param growthCycle
     * @param price
     */
    private WheatSeed(String name, Color color, Size size, String growthCycle, Double price) {
        super(name, color, size, growthCycle, price);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        WheatSeed wheatSeed = new WheatSeed(this.name, this.color, this.size, this.growthCycle, this.price);
        return wheatSeed;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public Double getPrice() {
        return price;
    }
}
