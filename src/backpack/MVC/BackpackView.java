package backpack.MVC;

import java.util.Map;
import java.util.Set;
import java.lang.Integer;

/**
 * 背包视图
 */
public class BackpackView {
    public  void printBackpack(Map maps){
        Set<Map.Entry<String, Integer>> set = maps.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            int value = entry.getValue();
            int length=key.length()-"背包".length();
            if(length>0&&length<3)
                System.out.println(key  + '\t' +'\t'+'\t' +value);
            else if(length>=3&&length<5)
                System.out.println(key   +'\t'+'\t' +value);
            else if(length>=5)
                System.out.println(key   +'\t' +value);
            else
                System.out.println(key  + '\t'+ '\t'+'\t' +'\t' +value);
        }

    }
}
