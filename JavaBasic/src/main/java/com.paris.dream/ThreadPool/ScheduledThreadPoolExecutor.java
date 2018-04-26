package com.paris.dream.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

    /* 定时任务 */
public class ScheduledThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 3;
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(corePoolSize);

    /*
     * 周期性调度任务，在delay后开始调度，适合执行时间比“间隔”短的任务
     * 并且任务开始时间的间隔为period，即“固定间隔”执行。
     * 如果任务执行的时间比period长的话，会导致该任务延迟执行，不会同时执行！
     * 如果任务执行过程抛出异常，后续不会再执行该任务！
     */
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(sdf.format(new Date()) + " A: do task");
            }
        }, 0, 5, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(sdf.format(new Date()) + " B: sleep");
                try {
                    Thread.sleep(20*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 10, 5, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(sdf.format(new Date()) + " C: throw Exception");
                throw new RuntimeException("test");
            }
        }, 30, 5, TimeUnit.SECONDS);
    }
}
