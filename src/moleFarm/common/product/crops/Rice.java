package moleFarm.common.product.crops;

import moleFarm.common.product.AbstractCrops;
import moleFarm.common.status.product.Color;
import moleFarm.common.status.product.Size;

/**
 * 水稻🌾
 */
public class Rice extends AbstractCrops implements Cloneable {
    /**
     * 名字
     */
    private final String name = "水稻\uD83C\uDF3E";
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
    private final Double price = 4.0;

    public Rice() {
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
