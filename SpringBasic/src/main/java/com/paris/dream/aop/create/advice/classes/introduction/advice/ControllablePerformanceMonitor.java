package com.paris.dream.aop.create.advice.classes.introduction.advice;

import com.paris.dream.aop.first.example.noproxy.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介增强：不是在目标方法周围织入增强，而是为目标类创建新的方法和属性。
 * 引介增强的连接点是类级别的，而非方法级别的。
 * 可以为目标类添加一个接口的实现，即原来目标类未实现某个接口，通过引介增强可以为目标类创建实现某接口的代理。
 * Created by Sydney on 2018/5/16.
 */
public class ControllablePerformanceMonitor
        extends DelegatingIntroductionInterceptor
        implements Monitorable{

    // 1. 定义了一个ThreadLocal类型的变量，用于之所以保存性能监视开关状态。
    // 之所以使用这个类型，是因为这个控制状态使代理类变成了非线程安全的实例；
    // 为了解决单实例线程安全的问题，通过ThreadLocal让每个线程单独使用一个状态。
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();
    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    // 3.拦截方法：用于拦截目标类方法的调用
    // 根据监视开关的状态有条件地对目标实例方法进行性能监视
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()){
            PerformanceMonitor.begin(mi.getClass().getName() + "."
                    + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
