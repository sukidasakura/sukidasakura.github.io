package com.paris.dream.FactoryPatterns;/*
package Learning.FactoryPatterns;

*/
/*
工厂方法模式

    工厂方法模式是简单工厂模式的进一步抽象化和推广，工厂方法模式里不再只由一个工厂类决定那一个产品类应当被实例化,这个决定被交给抽象工厂的子类去做。
    来看下它的组成：

    1、抽象工厂角色： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。在java中它由抽象类或者接口来实现。
    2、具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象
    3、抽象产品角色：它是具体产品继承的父类或者是实现的接口。在java中一般有抽象类或者接口来实现。
    4、具体产品角色：具体工厂角色所创建的对象就是此角色的实例。在java中由具体的类来实现。
    工厂方法模式使用继承自抽象工厂角色的多个子类来代替简单工厂模式中的“上帝类”。正如上面所说，这样便分担了对象承受的压力；而且这样使得结构变得灵活起来——
    当有新的产品（即暴发户的汽车）产生时，只要按照抽象产品角色、抽象工厂角色提供的合同来生成，那么就可以被客户使用，而不必去修改任何已有的代码。
    可以看出工厂角色的结构也是符合开闭原则的！
 *//*

public class FactoryMethodPattern {

    // 抽象产品角色
    public interface Moveable{
        void run();
    }

    // 具体产品角色
    public class Plane implements Moveable{
        @Override
        public void run(){
            System.out.println("plane...");
        }
    }

    // 抽象工厂
    public abstract class VehicleFactory {
        abstract Moveable create();
    }

    // 具体工厂
    public class PlaneFactory extends VehicleFactory{
        public Moveable create() {
            return new Plane();
        }
    }

    // 具体工厂
    public class BroomFactory extends VehicleFactory{
        public Moveable create() {
            return new Broom();
        }
    }

    // 测试类
    public class Test {
        public static void main(String[] args) {
            VehicleFactory factory = new BroomFactory();
            Moveable m = factory.create();
            m.run();
        }
    }
}

*/
/*
可以看出工厂方法的加入，使得对象的数量成倍增长。当产品种类非常多时，会出现大量的与之对应的工厂对象，这不是我们所希望的。
因为如果不能避免这种情况，可以考虑使用简单工厂模式与工厂方法模式相结合的方式来减少工厂类：即对于产品树上类似的种类（一般是树的叶子中互为兄弟的）使用简单工厂模式来实 现。

简单工厂和工厂方法模式的比较

工厂方法模式和简单工厂模式在定义上的不同是很明显的。工厂方法模式的核心是一个抽象工厂类，而不像简单工厂模式，把核心放在一个实类上。
工厂方法模式可以允许很多实的工厂类从抽象工厂类继承下来，从而可以在实际上成为多个简单工厂模式的综合,从而推广了简单工厂模式。
反过来讲，简单工厂模式是由工厂方法模式退化而来。设想如果我们非常确定一个系统只需要一个实的工厂类，那么就不妨把抽象工厂类合并到实的工厂类中去。而这样一来，我们就退化到简单工厂模式了。
*/