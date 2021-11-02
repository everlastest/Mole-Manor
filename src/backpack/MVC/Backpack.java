package backpack.MVC;

import molemall.other.shops.cart.CommodityForCart;

import java.util.HashMap;
import java.util.Map;

/**
 * 背包模型
 */
public class Backpack {

    private Map clothes;
    private Map food;

    public Backpack(){
        clothes=new HashMap<String,Integer>();
        food=new HashMap<String,Integer>();
        clothes.put("红色衬衫",1);
        clothes.put("黄色短裤",1);
        food.put("棒棒糖",5);
        food.put("面包",1);
    }

    public void AddClothes(String item,int num){
        Integer oriNum = (Integer) clothes.putIfAbsent(item, num);
        //背包原本有该物品，则将其累加
        if (oriNum != null) {
            clothes.put(item, num + oriNum);
            return;
        }
        //背包中没有该物品
        clothes.put(item,num);
    }
    public void AddFood(String item,int num){
        Integer oriNum = (Integer) food.putIfAbsent(item, num);
        //背包原本有该物品，则将其累加
        if (oriNum != null) {
            food.put(item, num + oriNum);
            return;
        }
        //背包中没有该物品
        food.put(item,num);

    }

    public Map getClothes() {
        return clothes;
    }

    public Map getFood() {
        return food;
    }
    Integer getClothesNum(String item){
         return ((Integer) clothes.get(item));
    }
    public Integer getFoodNum(String item){
        return ((Integer) food.get(item));
    }

    public void DelClothes(String item){
        clothes.remove(item);
    }
    public void DelFood(String item){
        clothes.remove(item);
    }

    }


