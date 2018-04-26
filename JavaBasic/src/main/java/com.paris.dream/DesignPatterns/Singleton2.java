package com.paris.dream.DesignPatterns;

/* Java设计模式之：单例模式:*/
public class Singleton2 {
    private static volatile Singleton2 sInst = null;       // <<< 这里添加了 volatile

    private Singleton2(){ }

    public static Singleton2 getSingleton(){
        Singleton2 inst = sInst;     // <<< 在这里创建临时变量
        if (inst == null){
            synchronized (Singleton2.class){
                inst = sInst;
                if (inst == null){
                    inst = new Singleton2();
                    sInst = inst;
                }
            }
        }
        return inst;  // <<< 注意这里返回的是临时变量
    }

    protected void method(){
        System.out.println("SingletonInner");
    }

/*    调用：
    Singleton.getInstance().method();

    优点：延迟加载，线程安全
    缺点： 写法复杂，不简洁*/

}
