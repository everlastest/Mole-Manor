package molemall.pattern.abstractfactory.factory;

import molemall.pattern.abstractfactory.AbstractClothes;
import molemall.pattern.abstractfactory.AbstractFactory;
import molemall.pattern.abstractfactory.AbstractFood;
import molemall.pattern.abstractfactory.AbstractSeed;
import molemall.pattern.bridge.ClothesColor;
import molemall.other.commodities.food.Hamburger;
import molemall.other.commodities.food.Soda;
import molemall.other.commodities.food.Watermelon;
import molemall.other.utils.JsonUtils;

import java.util.Objects;

public class FoodFactory implements AbstractFactory {
    final static String PATH = JsonUtils.getPathJson("Food");

    /**
     * @param newInstance
     */
    private static volatile FoodFactory foodFactory;
    private FoodFactory(){

    }
    public synchronized static FoodFactory newInstance(){
        if(foodFactory==null){
            foodFactory=new FoodFactory();
        }
        return foodFactory;
    }

    public AbstractFood CreateFood(String FoodType, double Price)
    {
        AbstractFood food=null;
        if(Objects.equals(FoodType, "Watermelon"))
        {
            food=new Watermelon(Price);
        }
        else if(Objects.equals(FoodType, "Soda"))
        {
            food=new Soda(Price);
        }
        else if(Objects.equals(FoodType, "Hamburger"))
        {
            food=new Hamburger(Price);
        }
        return food;
    }

    @Override
    public AbstractClothes CreateClothes(String ClothesType, Double Price, ClothesColor color) {
        return null;
    }

    @Override
    public AbstractSeed CreateSeed(String SeedType, double Price) {
        return null;
    }

    /**
     * 根据食品的名字生产对应的食品
     *
     * @param item
     * @return
     */
    @Override
    public AbstractFood create(String item) {
        return AbstractFactory.createCommodity(PATH + item);
    }
}
