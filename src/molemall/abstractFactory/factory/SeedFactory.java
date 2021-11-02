package molemall.abstractFactory.factory;

import molemall.abstractFactory.AbstractClothes;
import molemall.abstractFactory.AbstractFactory;
import molemall.abstractFactory.AbstractFood;
import molemall.abstractFactory.AbstractSeed;
import molemall.bridge.ClothesColor;
import molemall.commodities.seed.Cabbage;
import molemall.commodities.seed.Carrot;
import molemall.commodities.seed.Corn;
import molemall.utils.JsonUtils;

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
