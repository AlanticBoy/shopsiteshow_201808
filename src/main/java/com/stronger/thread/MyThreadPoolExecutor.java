package com.stronger.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:49 2018/6/23
 * @ModefiedBy:
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor{

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

}
