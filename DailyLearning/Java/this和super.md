##JAVA中的this和super

this的用法：  
1、普通的直接引用，this相当于是指向当前对象本身。  
2、形参与成员名字重名，用this来区分：  
```
public int GetAge(int age){
	this.age = age;
	return this.age;
}
```
3、引用构造函数（与下面super一起讲）  
super的用法：  
可以理解为是指向自己超（父）类对象的一个指针，而这个超类指的是离自己最近的一个父类。  
1、普通的直接引用。与this类似，super相当于是指向当前对象的父类，这样就可以用super.xxx来引用父类的成员。  
2、子类中的成员变量或方法与父类中的成员变量或方法同名  
```
class Country {
    String name;
    void value() {
       name = "China";
    }
}
  
class City extends Country {
    String name;
    void value() {
    name = "Shanghai";
    super.value();      //调用父类的方法
    System.out.println(name);
    System.out.println(super.name);
    }
  
    public static void main(String[] args) {
       City c=new City();
       c.value();
       }
}
```
3、引用构造函数
super（参数）：调用父类中的某一个构造函数（应该为构造函数中的第一条语句）。
this（参数）：调用本类中另一种形式的构造函数（应该为构造函数中的第一条语句）。

```
public class Chinese extends Person { 
    Chinese() { 
       super(); // 调用父类构造方法（1） 
    } 
    
    Chinese(String name) { 
       super(name);// 调用父类具有相同形参的构造方法（2） 
    } 
    
    Chinese(String name, int age) { 
       this(name);// 调用具有相同形参的构造方法（3） 
    } 
    
    public static void main(String[] args) { 
    } 
}
```