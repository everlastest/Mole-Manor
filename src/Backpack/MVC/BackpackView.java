package Backpack.MVC;

import java.util.Map;
import java.util.Set;
import java.lang.Integer;

public class BackpackView {
    public  void printBackpack(Map maps){
        Set<Map.Entry<String, Integer>> set = maps.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + '\t' + '\t' +'\t' +value);
        }

    }
}
