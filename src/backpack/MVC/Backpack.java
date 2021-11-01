package backpack.MVC;

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
        clothes.put("白色T恤",1);
        clothes.put("黑色短裤",1);
        food.put("棒棒糖",5);
        food.put("面包",1);
    }

    public void AddClothes(String item,int num){
        clothes.put(item,num);

    }
    public void AddFood(String item,int num){
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


