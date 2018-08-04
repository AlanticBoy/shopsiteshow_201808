package com.stronger.thread;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:31 2018/6/23
 * @ModefiedBy:
 */
public class ThreadTerminated {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Business()).start();
        }

    }

    static class Business implements Runnable {

        public void subMain() {
            System.out.println(Thread.currentThread().getName() + " exe ");
            System.out.println(" 共有线程数目   " + Thread.activeCount());
        }

        @Override
        public void run() {
            subMain();
        }
    }

}
