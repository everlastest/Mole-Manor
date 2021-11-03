package molemall.pattern.abstractfactory.factory;

import molemall.pattern.abstractfactory.AbstractClothes;
import molemall.pattern.abstractfactory.AbstractFactory;
import molemall.pattern.abstractfactory.AbstractFood;
import molemall.pattern.abstractfactory.AbstractSeed;
import molemall.pattern.bridge.ClothesColor;
import molemall.other.commodities.clothes.Jackets;
import molemall.other.commodities.clothes.Jeans;
import molemall.other.commodities.clothes.Shorts;
import molemall.other.commodities.clothes.Tshirt;
import molemall.other.utils.JsonUtils;

import java.util.Objects;

public class ClothesFactory implements AbstractFactory {
    final static String PATH = JsonUtils.getPathJson("Clothes");

    /**
     * @param newInstance
     */
    private static volatile ClothesFactory clothesFactory;
    private ClothesFactory(){

    }
    public synchronized static ClothesFactory newInstance(){
        if(clothesFactory==null){
            clothesFactory=new ClothesFactory();
        }
        return clothesFactory;
    }


    @Override
    public AbstractFood CreateFood(String FoodType, double Price) {
        return null;
    }

    public AbstractClothes CreateClothes(String item, Double Price, ClothesColor color)
    {
        AbstractClothes clothes=null;
        if(Objects.equals(item,"Jacket"))
        {
            clothes=new Jackets(color,Price);
        }
        else if(Objects.equals(item,"Jean"))
        {
            clothes=new Jeans(color,Price);
        }
        else if(Objects.equals(item,"Tshirt"))
        {
            clothes=new Tshirt(color,Price);
        }
        else if(Objects.equals(item,"Short"))
        {
            clothes=new Shorts(color,Price);
        }
        return clothes;
    }
    public AbstractSeed CreateSeed(String FoodType, double Price) {
        return null;
    }


    /**
     * 根据服装的名字生产对应的服装
     *
     * @param item
     * @return
     */
    @Override
    public AbstractClothes create(String item) {
        return AbstractFactory.createCommodity(PATH + item);
    }
}
