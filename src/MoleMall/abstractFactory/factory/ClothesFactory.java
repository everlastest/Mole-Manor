package MoleMall.abstractFactory.factory;

import MoleMall.abstractFactory.AbstractClothes;
import MoleMall.abstractFactory.AbstractFactory;
import MoleMall.abstractFactory.AbstractFood;
import MoleMall.abstractFactory.AbstractSeed;
import MoleMall.bridge.ClothesColor;
import MoleMall.commodities.clothes.Jackets;
import MoleMall.commodities.clothes.Jeans;
import MoleMall.commodities.clothes.Shorts;
import MoleMall.commodities.clothes.Tshirt;
import MoleMall.utils.JsonUtils;

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
