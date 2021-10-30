package MoleMall.abstractFactory.factory;

import MoleMall.abstractFactory.AbstractClothes;
import MoleMall.abstractFactory.AbstractFactory;
import MoleMall.abstractFactory.AbstractFood;
import MoleMall.abstractFactory.AbstractSeed;
import MoleMall.bridge.ClothesColor;
import MoleMall.commodities.food.Cabbage;
import MoleMall.commodities.food.Carrot;
import MoleMall.commodities.food.Corn;
import MoleMall.utils.JsonUtils;

import java.util.Objects;

public class SeedFactory implements AbstractFactory {
    final static String PATH = JsonUtils.getPathJson("Seed");
    @Override
    public AbstractFood CreateFood(String FoodType, double Price) {
        return null;
    }

    @Override
    public AbstractClothes CreateClothes(String ClothesType, Double Price, ClothesColor color) {
        return null;
    }

    public AbstractSeed CreateSeed(String item, double Price)
    {
        AbstractSeed seed=null;
        if(Objects.equals(item, "cabbage"))
        {
            seed=new Cabbage(Price);
        }
        else if(Objects.equals(item, "carrot"))
        {
            seed=new Carrot(Price);
        }
        else if(Objects.equals(item, "corn"))
        {
            seed=new Corn(Price);
        }
        return seed;
    }

    /**
     * 根据种子的名字生产对应的种子
     *
     * @param item
     * @return
     */
    @Override
    public AbstractClothes create(String item) {
        return AbstractFactory.createCommodity(PATH + item);
    }
}
