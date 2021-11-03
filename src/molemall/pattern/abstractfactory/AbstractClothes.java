package molemall.pattern.abstractfactory;


import molemall.pattern.bridge.ClothesColor;
import molemall.pattern.visitor.ClothesVisitor;

public abstract class AbstractClothes implements ICommodity{
    public ClothesColor color;
    protected Double price;
    protected String item;
    protected String style;
    public abstract void Purchase();//购买
    public abstract void transfer();//与仓库进行转移
    public abstract Double getPrice();
    public abstract String getItem();
    public abstract String getColor();
    public abstract void setItem();
    /**
     * visitor模式：接受租赁和购买两种操作
     * @param clothesVisitor
     */
    public abstract void accept(ClothesVisitor clothesVisitor);
}
