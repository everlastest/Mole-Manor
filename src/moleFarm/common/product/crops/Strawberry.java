package moleFarm.common.product.crops;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 草莓🍓
 */
public class Strawberry extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "草莓\uD83C\uDF53";
    /**
     * 颜色
     */
    private final Color color = Color.RED;
    /**
     * 大小
     */
    private final Size size = Size.MEDIUM;
    /**
     * 价格
     */
    private final Double price = 30.0;

    /**
     * 构造方法
     *
     * @param name
     * @param color
     * @param size
     * @param price
     */
    private Strawberry(String name, Color color, Size size, Double price) {
        super(name, color, size, price);
    }

    public Strawberry() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Strawberry strawberry = new Strawberry(this.name, this.color, this.size, this.price);
        return strawberry;
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
