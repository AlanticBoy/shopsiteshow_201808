package com.stronger.generic;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:16 2018/6/17
 * @ModefiedBy:
 */
public class Service<T extends Runnable> implements Delayed{

    Runnable task;


    public long getDelay(TimeUnit unit) {
        return 0;
    }

    public int compareTo(Delayed o) {
        return 0;
    }
}
