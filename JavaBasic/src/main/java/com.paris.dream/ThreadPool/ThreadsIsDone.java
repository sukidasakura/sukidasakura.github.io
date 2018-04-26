package com.paris.dream.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadsIsDone implements Runnable{
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                2, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 2; i++) {
            pool.submit(new ThreadsIsDone());
        }
        System.out.println("pool.getTaskCount():" + pool.getTaskCount());
        System.out.println("pool.getCompletedTaskCount():" + pool.getCompletedTaskCount());
        boolean allThreadIsDone = pool.getTaskCount() == pool.getCompletedTaskCount();
        System.out.println("the value of allThreadIsDone is:" + allThreadIsDone);
        if (allThreadIsDone){
            System.out.println("全部执行完成");
        } else {
            System.out.println("未执行完成");
        }
        pool.shutdown();
        while (!allThreadIsDone){
            allThreadIsDone = pool.getTaskCount() == pool.getCompletedTaskCount();
            if (allThreadIsDone){
                System.out.println("全部执行完成");

            }
        }

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 2; i++) {
//            executorService.submit(new ThreadsIsDone());
//        }
//        executorService.shutdown();

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
    }
}
