package com.supconit.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2019年11月14日 16:51
 */
public class HelloUdf extends UDF{
    public String evaluate(String str){
        try {
            return "HelloWorld " + str;
        } catch (Exception e) {
            return null;
        }
    }
}
