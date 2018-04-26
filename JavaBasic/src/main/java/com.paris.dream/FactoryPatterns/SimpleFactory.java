package com.paris.dream.FactoryPatterns;/*
package Learning.FactoryPatterns;
*/
/*
工厂模式
    基本概念：为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。
    分为三类：
    1、简单工厂模式Simple Factory：不利于产生系列产品；
    2、工厂方法模式Factory Method：又称为多形性工厂；
    3、抽象工厂模式Abstract Factory：又称为工具箱，产生产品族，但不利于产生新的产品；
    这三种模式从上到下逐步抽象，并且更具一般性。
    GOF在《设计模式》一书中将工厂模式分为两类：工厂方法模式（Factory Method）与抽象工厂模式（Abstract Factory）。
    将简单工厂模式（Simple Factory）看为工厂方法模式的一种特例，两者归为一类。
*//*


*/
/*
简单工厂模式：
    简单工厂模式又称静态工厂方法模式。重命名上就可以看出这个模式一定很简单。它存在的目的很简单：定义一个用于创建对象的接口。
    在简单工厂模式中，一个工厂类处于对产品类实例化调用的中心位置上，它决定哪一个产品类应当被实例化，如同一个交通警察站在来往的车辆流中，决定放行哪一个方向的车辆向那一个方向流动一样。
    先来看看它的组成：
    1、工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑。在java中它往往由一个具体类实现。
    2、抽象产品角色：它一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类来实现。
    3、具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。
*//*


import javassist.tools.rmi.Sample;

public class SimpleFactory { //getClass 产生Sample 一般可使用动态类装载装入类。
    public static Sample creator(int which){
        if (which == 1){
            return new SampleA();
        } else if(which == 2){
            return new SampleB();
        }
    }
}

*/
/*
    还有一种目前比较流行的规范是把静态工厂方法命名为valueOf 或者getInstance。
    valueOf：该方法返回的实例与它的参数具有同样的值，例如：
    Integer a=Integer.valueOf(100); //返回取值为100的Integer对象
 *//*


class Complex{
    private final float re;
    private final float im;

    private Complex(float re, float im){
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(float re, float im){
        return new Complex(re, im);
    }

    public static Complex valueOfPolar(float r, float theta){
        return new Complex((float)(r * Math.cos(theta)), (float)(r * Math.sin(theta)));
    }
}
*/
/*
    从上面代码可以看出，valueOf()方法能执行类型转换操作，在本例中，把int类型的基本数据转换为Integer对象。
    getInstance：返回的实例与参数匹配，例如：
    Calendar cal=Calendar.getInstance(Locale.CHINA); //返回符合中国标准的日历
 *//*



*/
