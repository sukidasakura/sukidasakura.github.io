package com.paris.dream.ThreadPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class TimerLearning {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("do task...");
            }
        };

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timer timer = new Timer();
        try {
            timer.schedule(task, sdf.parse("2018-3-10 00:00:00"), 5000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
