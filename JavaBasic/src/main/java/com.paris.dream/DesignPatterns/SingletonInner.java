package com.paris.dream.DesignPatterns;

public class SingletonInner {
    /*
      内部类实现单例模式
      延迟加载，减少内存开销
     */
    private static class SingletonHolder{
        private static SingletonInner instance = new SingletonInner();
    }

    private SingletonInner(){}

    public static SingletonInner getInstance(){
        return SingletonHolder.instance;
    }

    protected void method(){
        System.out.println("SingletonInner");
    }

/*
    调用：Singleton.getInstance().method();
    优点：延迟加载，线程安全（java中class加载时互斥的），也减少了内存消耗，推荐使用内部类方式。
*/

}
