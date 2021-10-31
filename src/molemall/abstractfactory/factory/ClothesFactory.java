package molemall.abstractfactory.factory;

import molemall.abstractfactory.AbstractClothes;
import molemall.abstractfactory.AbstractFactory;
import molemall.abstractfactory.AbstractFood;
import molemall.abstractfactory.AbstractSeed;
import molemall.bridge.ClothesColor;
import molemall.commodities.clothes.Jackets;
import molemall.commodities.clothes.Jeans;
import molemall.commodities.clothes.Shorts;
import molemall.commodities.clothes.Tshirt;
import molemall.utils.JsonUtils;

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
