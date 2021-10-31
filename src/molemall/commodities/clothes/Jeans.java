package molemall.commodities.clothes;

import molemall.abstractfactory.AbstractClothes;
import molemall.bridge.ClothesColor;
import molemall.visitor.ClothesVisitor;

public class Jeans extends AbstractClothes {

    protected ClothesColor color;

    public void setColor(ClothesColor color)
    {
        this.color = color;
    }

    public Jeans()
    {
        this.item="牛仔裤";
        this.color=null;
        this.style="nbber";
        this.price=120.0;
    }

    public  Jeans(ClothesColor color, Double price)
    {
        this.item="牛仔裤";
        this.style="nbber";
        this.price=price;
        setColor(color);
    }
    public Double getPrice() {
        return price;
    }
    public String getItem() {
        return item;
    }
    @Override
    public void Purchase() {
        System.out.printf("You have bought a "+this.color.color+" "+this.item);
    }

    @Override
    public void transfer() {
        System.out.printf("You have transferred a "+this.color.color+" "+this.item);
    }
    @Override
    public void accept(ClothesVisitor clothesVisitor) {
        clothesVisitor.visit(this);
    }
}
