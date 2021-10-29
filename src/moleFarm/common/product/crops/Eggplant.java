package moleFarm.common.product.crops;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 茄子🍆
 */
public class Eggplant extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "茄子\uD83C\uDF46";
    /**
     * 颜色
     */
    private final Color color = Color.PURPLE;
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
    private Eggplant(String name, Color color, Size size, Double price) {
        super(name, color, size, price);
    }

    public Eggplant() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Eggplant eggplant = new Eggplant(this.name, this.color, this.size, this.price);
        return eggplant;
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
