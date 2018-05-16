package com.paris.dream.aop.first.example.noproxy;

/**
 * 包含性能监视横切代码
 * 每个service类和每个业务方法体的前后都执行相同的代码逻辑
 * 当某个方法需要进行性能监视，就必须调整方法代码，在方法体前后分别添加上开启性能监视和结束性能监视的代码。
 * 这些非业务逻辑的性能监视代码破坏了ForumServiceImp业务逻辑的纯粹性。
 * 我们希望通过代理的方式，将业务代码中开启和结束性能监视的这些横切代码从业务类中完全移除。
 * 并通过JDK动态代理或者CGlib动态代理将横切代码动态织入到目标方法的相应位置。
 * Created by Sydney on 2018/5/16.
 */
public class ForumServiceImpl implements ForumService{

    public void removeTopic(int topicid){
        // 1-1.开始对方法进行性能监视
        PerformanceMonitor.begin("com.paris.dream.aop.first.example.removeTopic");
        System.out.println("模拟删除Topic记录：" + topicid);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1-2. 结束对该方法进行性能监视
        PerformanceMonitor.end();
    }

    public void removeForum(int forumid){
        // 2-1.开始对方法进行性能监视
        PerformanceMonitor.begin("com.paris.dream.aop.first.example.removeForum");
        System.out.println("模拟删除Forum记录：" + forumid);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2-2. 结束对该方法进行性能监视
        PerformanceMonitor.end();
    }

}
