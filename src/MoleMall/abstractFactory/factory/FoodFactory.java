package MoleMall.abstractFactory.factory;

import MoleMall.abstractFactory.AbstractClothes;
import MoleMall.abstractFactory.AbstractFactory;
import MoleMall.abstractFactory.AbstractFood;
import MoleMall.abstractFactory.AbstractSeed;
import MoleMall.bridge.ClothesColor;
import MoleMall.commodities.food.Hamburger;
import MoleMall.commodities.food.Soda;
import MoleMall.commodities.food.Watermelon;
import MoleMall.utils.JsonUtils;

import java.util.Objects;

public class FoodFactory implements AbstractFactory {
    final static String PATH = JsonUtils.getPathJson("Food");

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
    public AbstractClothes create(String item) {
        return AbstractFactory.createCommodity(PATH + item);
    }
}
