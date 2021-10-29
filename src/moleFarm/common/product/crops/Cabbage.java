package moleFarm.common.product.crops;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 白菜🥦
 */
public class Cabbage extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "白菜\uD83E\uDD66";
    /**
     * 颜色
     */
    private final Color color = Color.GREEN;
    /**
     * 大小
     */
    private final Size size = Size.MEDIUM;
    /**
     * 价格
     */
    private final Double price = 10.0;

    /**
     * 构造方法
     *
     * @param name
     * @param color
     * @param size
     * @param price
     */
    private Cabbage(String name, Color color, Size size, Double price) {
        super(name, color, size, price);
    }

    public Cabbage() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Cabbage cabbage = new Cabbage(this.name, this.color, this.size, this.price);
        return cabbage;
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

    @Override
    public String getName() {
        return name;
    }

}
