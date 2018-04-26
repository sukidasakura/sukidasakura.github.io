package com.paris.dream.DesignPatterns;

/* Java设计模式之：单例模式:*/
public class Singleton1 {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton1 instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton1() {}

    /* 1:懒汉式，静态工程方法，创建实例 */
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

/*    调用：Singleton.getInstance().method();
    优点：延迟加载（需要的时候才去加载）,适合单线程操作
    缺点： 线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。*/
}
