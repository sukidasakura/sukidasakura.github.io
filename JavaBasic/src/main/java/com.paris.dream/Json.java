package com.paris.dream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Mashencai on 2018/5/25.
 */
public class Json {
    public static void main(String[] args) {

        // Json对象中添加的是键值对，JsonArray中添加的是Json对象
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject1.put("001", "Tom");

        // Json对象中添加键值对
        jsonObject.put("key", "value");

        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);

        System.out.println(jsonArray.toString());

        // 输出结果：[{"key":"value"},{"001":"Tom"}]
    }
}
