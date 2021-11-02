package molemall.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonUtils {
    /**
     * 通过路径读取json文件，返回jsonobject对象
     *
     * @param jsonPath
     * @return
     * @throws FileNotFoundException
     */
    private static JSONObject getJson(String jsonPath) throws FileNotFoundException {
        JSONReader jsonReader = new JSONReader(new FileReader(jsonPath));
        return (JSONObject) jsonReader.readObject();
    }
    public static Map<String, String> searchMapper() {
        try {
            String jsonPath = "src/MoleMall/resources/mapper.json";
            JSONObject json = getJson(jsonPath);
            String s = json.toJSONString();
            return (Map<String, String>) JSON.parseObject(s, Map.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
//    /**
//     * 解析clothes.json
//     *
//     * @param clothesType
//     * @return
//     */
//    public static List<String> SearchJson(ClothesType clothesType) {
//        String text = clothesType.getText();
//        String jsonPath = "src.resources.clothes.json";
//        List<String> list = null;
//        try {
//            JSONObject json = getJson(jsonPath);
//            JSONObject temp = (JSONObject) (json.get("clothes"));
//            list = (List<String>) temp.get(text);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(list);
//        return list;
//    }

    /**
     * 工具类用来解析
     *
     * @param name
     * @return
     */
    public static String getPathJson(String name) {
        String jsonPath = "src/MoleMall/resources/path.json";
        try {
            JSONObject json = getJson(jsonPath);
            return (String) json.get(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    /**
//     * 解析path.json
//     *
//     * @param name
//     * @return
//     */
//    public static String getPathJson(String name) {
//        return utilSearchJson(name, "path", "ICommodity");
//    }
}
