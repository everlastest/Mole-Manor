package molemall.commodities.seed;

import molemall.abstractFactory.AbstractSeed;

public class Cabbage implements AbstractSeed {

    protected String item;
    protected double price;

    public Cabbage()
    {
        this.item="cabbage";
        this.price=0;
    }

    public Cabbage(double price)
    {
        this.item="cabbage";
        this.price=price;
    }

    @Override
    public void transfer() {
        System.out.printf("You have transferred a cabbage seed");
    }

    @Override
    public void Purchase() {
        System.out.printf("You have bought a cabbage seed");
    }
}
