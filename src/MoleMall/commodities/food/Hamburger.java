package MoleMall.commodities.food;

import MoleMall.abstractFactory.AbstractFood;

public class Hamburger implements AbstractFood {
    protected double price;
    protected String item;

    public Hamburger(double price)
    {
        this.price=price;
        this.item="hamburger";
    }

    public Hamburger()
    {
        this.price=0;
        this.item="hamburger";
    }

    @Override
    public void Purchase()
    {
        System.out.printf("You have bought a hamburger");
    }

    @Override
    public void transfer()
    {
        System.out.printf("Transfer hamburger completed");
    }
}
