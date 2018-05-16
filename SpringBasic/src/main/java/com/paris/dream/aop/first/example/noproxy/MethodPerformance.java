package com.paris.dream.aop.first.example.noproxy;

/**
 * 用于记录性能监视信息的MethodPerformance
 * 必须与PerformanceMonitor嵌套使用
 * Created by Sydney on 2018/5/16.
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis(); //记录目标类方法开始执行点的时间
    }

    // 获取目标类方法执行完后的系统时间，并进而计算出目标类方法执行时间
    public  void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        // 报告目标类方法的执行时间
        System.out.println(serviceMethod + "花费" + elapse + "毫秒");
    }
}
