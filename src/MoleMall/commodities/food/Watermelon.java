package MoleMall.commodities.food;

import MoleMall.abstractFactory.AbstractFood;

public class Watermelon implements AbstractFood {

    protected double price;
    protected String item;

    public Watermelon(double price)
    {
        this.price=price;
        this.item="watermelon";
    }

    public Watermelon()
    {
        this.price=0;
        this.item="watermelon";
    }

    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a watermelon");
    }

    @Override
    public void transfer()
    {
        System.out.printf("Transfer watermelon completed");
    }

}
