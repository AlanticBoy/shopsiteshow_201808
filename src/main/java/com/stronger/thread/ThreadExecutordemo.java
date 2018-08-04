package com.stronger.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:45 2018/6/23
 * @ModefiedBy:
 */
public class ThreadExecutordemo {
    public static void main(String[] args) {
        final AtomicInteger ctl=new AtomicInteger(0);
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
        threadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(" start exectuting  ,while times is "+ctl.getAndIncrement());
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}
