package com.stronger.executors;

import com.stronger.util.RandomUtil;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  17:08 2018/6/19
 * @ModefiedBy:
 */
public class ExecutorsDemo {

    @Test
    public void test() {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();

    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
       /* for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" while string is "+RandomUtil.randomString(20));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/

        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " and string is " + RandomUtil.randomString(20));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
