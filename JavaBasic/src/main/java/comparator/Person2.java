package comparator;

/**
 * @Description:
 * @author: mashencai@supcon.com
 * @date: 2018年06月08日 11:19
 */
public final class Person2 {
    private int age;
    private String name;

    public Person2(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
