package moleFarm.common.product.crops;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 西瓜🍉
 */
public class Watermelon extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "西瓜\uD83C\uDF49";
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
    private final Double price = 20.0;

    /**
     * 构造方法
     *
     * @param name
     * @param color
     * @param size
     * @param price
     */
    private Watermelon(String name, Color color, Size size, Double price) {
        super(name, color, size, price);
    }

    public Watermelon() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Watermelon watermelon = new Watermelon(this.name, this.color, this.size, this.price);
        return watermelon;
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
