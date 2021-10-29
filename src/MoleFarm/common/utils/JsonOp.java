package MoleFarm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import MoleFarm.common.status.other.ProductType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JsonOp {
    private static String commonPath = "src/";

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
            String jsonPath = commonPath + "MoleFarm/common/resources/mapper.json";
            JSONObject json = getJson(jsonPath);
            String s = json.toJSONString();
            return (Map<String, String>) JSON.parseObject(s, Map.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析farm.json
     *
     * @param productType
     * @return
     */
    public static List<String> SearchJson(ProductType productType) {
        String text = productType.getText();
        String jsonPath = commonPath + "MoleFarm/common/resources/farm.json";
        List<String> list = null;
        try {
            JSONObject json = getJson(jsonPath);
            JSONObject temp = (JSONObject) (json.get("farm"));
            list = (List<String>) temp.get(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 工具类用来解析
     *
     * @param name
     * @param fileName
     * @param difference
     * @return
     */
    public static String utilSearchJson(String name, String fileName, String... difference) {
        String jsonPath = commonPath + "MoleFarm/common/resources/" + fileName + ".json";
        int size = difference.length;
        try {
            JSONObject json = getJson(jsonPath);
            if (size == 1) {
                if (Objects.equals(name, difference[0])) {
                    return (String) json.get(name);
                } else {
                    JSONObject factory = (JSONObject) json.get("factory");
                    JSONObject conc = (JSONObject) factory.get("conc");
                    return (String) conc.get(name);
                }
            } else {
                if (Objects.equals(name, difference[0]) || Objects.equals(name, difference[1])) {
                    return (String) json.get(name);
                } else {
                    JSONObject factory = (JSONObject) json.get("factory");
                    JSONObject conc = (JSONObject) factory.get("conc");
                    return (String) conc.get(name);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析path.json
     *
     * @param name
     * @return
     */
    public static String getPathJson(String name) {
        return utilSearchJson(name, "path", "IFactory");
    }

    /**
     * 解析msg.json
     *
     * @param name
     * @return
     */
    public static String getMsgJson(String name) {
        return utilSearchJson(name, "msg", "FarmProductFactory", "IFactory");
    }

}
