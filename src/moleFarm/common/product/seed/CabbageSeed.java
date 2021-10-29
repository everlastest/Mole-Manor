package moleFarm.common.product.seed;

import moleFarm.common.product.AbstractSeed;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 白菜种子
 */
public class CabbageSeed extends AbstractSeed implements Cloneable {
    protected CabbageSeed(String name, Color color, Size size, String growthCycle, Double price) {
        super(name, color, size, growthCycle, price);
    }

    /**
     * 名字
     */
    private String name = "白菜种子";
    /**
     * 颜色
     */
    private Color color = Color.BLACK;
    /**
     * 大小
     */
    private Size size = Size.MEDIUM;
    /**
     * 生长周期
     */
    private String growthCycle = "90天";
    /**
     * 价格
     */
    private Double price = 3.0;

    public CabbageSeed() {
    }

    /**
     * 原型模式，重写clone方法
     *
     * @return
     */
    @Override
    public Object clone() {
        CabbageSeed cabbageSeed = new CabbageSeed(this.name, this.color, this.size, this.growthCycle, this.price);
        return cabbageSeed;
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
