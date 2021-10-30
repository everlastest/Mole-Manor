package MoleMall.commodities.food;

import MoleMall.abstractFactory.AbstractFood;

public class Soda implements AbstractFood {
    protected double price;
    protected String item;

    public Soda(double price)
    {
        this.price=price;
        this.item="soda";
    }

    public Soda()
    {
        this.price=0;
        this.item="soda";
    }

    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a Soda");
    }

    @Override
    public void transfer()
    {
        System.out.printf("Transfer Soda completed");
    }
}
