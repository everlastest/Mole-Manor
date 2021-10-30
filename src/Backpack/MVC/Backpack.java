package Backpack.MVC;
import Framework.SimpleFactory.Mole;
import java.util.Iterator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
public class Backpack {

    private Map clothes=new HashMap<String,Integer>();
    private Map food=new HashMap<String,Integer>();
    public void Addclothes(String item,int num){
        clothes.put(item,num);

    }
    public void Addfood(String item,int num){
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

    public void Delclothes(String item){
        clothes.remove(item);
    }
    public void Delfood(String item){
        clothes.remove(item);
    }

    }


