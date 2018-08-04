package com.stronger.thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  14:36 2018/6/17
 * @ModefiedBy:
 */
public class ThreadCommunication {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    @Test
    public void test() {
        final Business business = new Business();
        new Thread(new Runnable() {
            public void run() {
                for (int k = 0; k < 50; k++) {
                    business.subMain(k);
                }
            }
        }).start();
        for (int k = 0; k < 50; k++) {
            business.takeMain(k);
        }
    }


    private class Business {
        private boolean isOk = true;

        public void subMain(int outer) {
            lock.lock();
            while (!isOk) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(" subMain inner loop is " + i + "  while outer loop of " + outer);
                }
                isOk = false;
                condition2.signal();
            } finally {
                lock.unlock();
            }

        }

        public void takeMain(int outer) {
            lock.lock();
            while (isOk) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(" takeMain loop is " + i + "  while takeMain loop of " + outer);
                }
                condition.signal();
                isOk = true;
            } finally {
                lock.unlock();
            }

        }

    }
}
