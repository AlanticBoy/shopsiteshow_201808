package com.stronger.blockingqueue;

import com.stronger.util.RandomUtil;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  16:10 2018/6/19
 * @ModefiedBy:
 */
public class ParseLogger {

    public static void main(String[] args) {
         /*这样打印需要16秒钟*/
         /*for (int i = 0; i < 16; i++) {
            parseLog(RandomUtil.randomString(20));
        }
        */
        /*这样差不多需要一秒钟*/
         /*for (int i=0;i<16;i++){
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     parseLog(RandomUtil.randomString(16));
                 }
             }).start();
         }*/
        final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(16);

        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String log = blockingQueue.take();
                            parseLog(log);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 16; i++) {
            try {
                blockingQueue.put(RandomUtil.randomString(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*while (true){
            try {
                System.out.println(""+new Date().getSeconds());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */
    }

    public static void parseLog(String log) {
        System.out.println("  " + log);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
