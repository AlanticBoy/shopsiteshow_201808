package com.stronger.thread;

import com.stronger.util.RandomUtil;

import java.util.concurrent.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:13 2018/6/18
 * @ModefiedBy:
 */
public class BlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);

        new Thread(new ProductThread(blockingQueue)).start();
        new Thread(new ConsumerThread(blockingQueue)).start();

    }

    private static class ProductThread implements Runnable {
        BlockingQueue<String> blockingQueue;

        public ProductThread(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    blockingQueue.put(RandomUtil.randomString(8));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ConsumerThread implements Runnable {

        BlockingQueue<String> blockingQueue;

        public ConsumerThread(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " 正在等待 ");
                    String cont = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " 将要消费 " + cont);
                    for (int i = 0; i < cont.length(); i++) {
                        System.out.print(" " + cont.charAt(i));
                    }
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
