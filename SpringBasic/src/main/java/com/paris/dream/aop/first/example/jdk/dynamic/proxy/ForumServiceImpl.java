package com.paris.dream.aop.first.example.jdk.dynamic.proxy;

import com.paris.dream.aop.first.example.noproxy.PerformanceMonitor;

/**
 * 移除性能监视横切代码，只保留真正的业务逻辑。
 * Created by Sydney on 2018/5/16.
 */
public class ForumServiceImpl implements ForumService{

    public void removeTopic(int topicid){
        // 1-1.在此原有的横切代码被移除（抽取切面中）
        System.out.println("模拟删除Topic记录：" + topicid);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1-2. 在此原有的横切代码被移除（抽取切面中）
    }

    public void removeForum(int forumid){
        // 2-1.在此原有的横切代码被移除（抽取切面中）
        System.out.println("模拟删除Forum记录：" + forumid);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2-2. 在此原有的横切代码被移除（抽取切面中）
    }

}
