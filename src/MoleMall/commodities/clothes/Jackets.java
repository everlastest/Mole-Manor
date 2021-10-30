package MoleMall.commodities.clothes;

import MoleMall.abstractFactory.AbstractClothes;
import MoleMall.bridge.ClothesColor;
import MoleMall.visitor.ClothesVisitor;

/**
 * 夹克
 */
public class Jackets extends AbstractClothes {

    protected ClothesColor color;

    public void setColor(ClothesColor color)
    {
        this.color = color;
    }

    public Jackets()
    {
        this.item="夹克";
        this.color=null;
        this.style="upper";
        this.price=200.0;
    }

    public  Jackets(ClothesColor color, Double price)
    {
        this.item="夹克";
        this.style="upper";
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
