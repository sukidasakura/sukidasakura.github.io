package comparator;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年06月08日 11:02
 */
public class Person1 implements Comparable<Person1>{

    private int age;
    private String name;

    public Person1(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person1 o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
