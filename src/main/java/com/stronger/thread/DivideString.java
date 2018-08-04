package com.stronger.thread;

import com.stronger.util.RandomUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:31 2018/6/6
 * @ModefiedBy:
 */
public class DivideString {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool= Executors.newFixedThreadPool(10);
        for (int i=0;i<200;i++){
            threadPool.execute(new PrintString(RandomUtil.randomString(8)));
           TimeUnit.MILLISECONDS.sleep(30);
        }
        threadPool.shutdown();
    }

}
