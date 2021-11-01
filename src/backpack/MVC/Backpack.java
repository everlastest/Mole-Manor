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


