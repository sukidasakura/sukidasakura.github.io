package com.paris.dream.aop.first.example.noproxy;

/**
 * 性能监视实现类
 * 必须与MethodPerformance类嵌套使用
 * 通过调用begin(String method)开始对某个目标类方法的监视
 * end()方法结束对目标类方法的监视
 * Created by Sydney on 2018/5/16.
 */
public class PerformanceMonitor {
    /*
     1.通过一个ThreadLocal保存调用线程相关的性能监视信息
     -> ThreadLocal类接口：（是将非线程安全类改造为线程安全类的法宝）
     void set(Object value)设置当前线程的线程局部变量的值。
     public Object get()该方法返回当前线程所对应的线程局部变量。
    */
    private static ThreadLocal<MethodPerformance> performanceRecord =
            new ThreadLocal<MethodPerformance>();

    // 2.启动对某一目标方法的性能监视
    public static void begin(String method){
        System.out.println("begin monitor..");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();

        // 3.打印出方法性能监视的结果信息
        mp.printPerformance();
    }
}

