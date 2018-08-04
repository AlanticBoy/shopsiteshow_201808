package com.stronger.queue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  19:46 2018/6/28
 * @ModefiedBy:
 */
public class BlockingDemo {
    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);

    public static void main(String[] args) throws InterruptedException {
        blockingQueue.put("aaa");
        blockingQueue.put("bbb");
        blockingQueue.put("ccc");
        blockingQueue.put("ddd");
        blockingQueue.put("eee");

        int a = 0, b = 0, c = 0;
        String elem = blockingQueue.peek();
        System.out.println(" take the first  element  " + elem);
        if (++a == 1) {
            String element = blockingQueue.take();
            blockingQueue.put(element);
        }
        System.out.println("##########################################");
        /*#################################*/
        String el = blockingQueue.peek();
        System.out.println("  take the second element  " + el);
        if (++b == 1) {
            String element = blockingQueue.take();
            blockingQueue.put(element);
        }
        System.out.println("##########################################");
        String ele = blockingQueue.peek();
        System.out.println("  take the third element  " + ele);
        if (++c == 1) {
            String element = blockingQueue.take();
            blockingQueue.put(element);
        }
        System.out.println("##########################################");

        Iterator<String> iterator = blockingQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
    }

}
