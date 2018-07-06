package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: Comparable和Comparator的比较程序
 * @author: mashencai@supcon.com
 * @date: 2018年06月08日 11:00
 */
public class Compare {
    public static void main(String[] args) {
        // 测试Person1
        Person1 person1 = new Person1("zzh",18);
        Person1 person2 = new Person1("jj",17);
        Person1 person3 = new Person1("qq",19);

        List<Person1> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }

}
