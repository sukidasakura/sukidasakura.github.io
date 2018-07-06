package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类Person2已经固定，无法进行对其类自身的修改，也修饰词final了，
 * 你也别想继承再implements Comparable，那么此时怎么办呢？在类的外部使用Comparator的接口。
 */
public class Comparator {
    public static void main(String[] args) {
        Person2 p1 = new Person2("zzh",18);
        Person2 p2 = new Person2("jj",17);
        Person2 p3 = new Person2("qq",19);
        List<Person2> list2 = new ArrayList<Person2>();
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);
        System.out.println(list2);

        Collections.sort(list2, new java.util.Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                if(o1 == null || o2 == null)
                    return 0;
                return o1.getAge()-o2.getAge();
            }
        });

        System.out.println(list2);
    }
}
