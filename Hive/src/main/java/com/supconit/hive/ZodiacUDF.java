package com.supconit.hive;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2019年11月13日 16:33
 */
public class ZodiacUDF extends UDF {
    private SimpleDateFormat df;
    private static final String[] zodiacArr = { "猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊" };

    public ZodiacUDF() {
        df = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * 继承类UDF中的evaluate()函数
     *
     * @param date
     * @return
     */
    public String evaluate(String date) {
        Date dt = null;
        try {
            dt = df.parse(date);
        } catch (Exception ex) {
            return null;
        }
        return this.zodiac(dt.getYear() + 1900);
    }

    /**
     * 计算生肖
     *
     * @param year
     * @return
     */
    public String zodiac(Integer year) {
        return zodiacArr[year % 12];
    }

    public static void main(String[] args) {
        ZodiacUDF zf = new ZodiacUDF();
        System.out.println(zf.evaluate("1996-4-27"));
    }
}
