package com.paris.dream.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Sydney on 2018/5/11.
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        // 通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.paris.dream.java.reflect.Car");

        // 通过Car的反射类对象获取Car的构造函数对象cons，并通过它实例化Car
        // 效果等同于new Car()
        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car)cons.newInstance();

        //通过Car反射类对象的getMethod反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        // 通过invoke调用目标类的方法，第一个参数是操作的目标类对象实例，第二个是目标方法的入参
        setBrand.invoke(car, "红旗CA72");

        Field colorFld = clazz.getDeclaredField("color");
        // 在访问private、protected成员变量和方法时必须
        // 通过setAccessible(boolean access)方法取消Java语言访问检查
        colorFld.setAccessible(true);
        colorFld.set(car, "红色");

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
