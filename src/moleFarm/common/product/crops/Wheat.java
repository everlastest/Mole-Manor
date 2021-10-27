package moleFarm.common.product.crops;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 小麦🌿
 */
public class Wheat extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "小麦\uD83C\uDF3F";
    /**
     * 颜色
     */
    private final Color color = Color.BROWN;
    /**
     * 大小
     */
    private final Size size = Size.SMALL;
    /**
     * 价格
     */
    private final Double price = 5.0;

    /**
     * 构造方法
     *
     * @param name
     * @param color
     * @param size
     * @param price
     */
    private Wheat(String name, Color color, Size size, Double price) {
        super(name, color, size, price);
    }

    public Wheat() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Wheat wheat = new Wheat(this.name, this.color, this.size, this.price);
        return wheat;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Double getPrice() {
        return price;
    }

}
