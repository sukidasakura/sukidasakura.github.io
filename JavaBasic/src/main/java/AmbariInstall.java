import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年12月03日 16:04
 */
public class AmbariInstall {
    public static void main(String[] args) throws IOException {
        File file = new File("G:\\Git\\sukidasakura.github.io\\JavaBasic\\src\\main\\resources\\config.txt");
        String str = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                str += line;
            }
        }
        JSONObject jsonObject = JSON.parseObject(str);
        JSONArray items = jsonObject.getJSONArray("items");
        JSONObject item = items.getJSONObject(0);
        JSONArray configurations = item.getJSONArray("configurations");
        for (int i = 0; i < configurations.size(); i++) {
            String type = configurations.getJSONObject(i).getString("type");
            JSONObject properties = configurations.getJSONObject(i).getJSONObject("properties");
            Iterator<String> iterator = properties.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = properties.getString(key);
                value = value.replace("\n", "\\n").replace("\"", "\\\"");
                System.out
                        .println(underlineToCamel(type) + ".put(\"" + key + "\",\"" + value + "\"" + ");");
            }
            System.out.println();
        }
    }

    private static String underlineToCamel(String str) {
        int index = str.indexOf('_');
        String tmp = "";
        if (index < -1) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                i++;
                tmp += Character.toUpperCase(str.charAt(i));
            } else {
                tmp += str.charAt(i);
            }
        }
        return tmp;
    }
}
