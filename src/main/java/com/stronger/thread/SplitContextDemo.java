package com.stronger.thread;

import com.stronger.util.RandomUtil;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  19:03 2018/6/17
 * @ModefiedBy:
 */
public class SplitContextDemo implements Runnable {
    private ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>();

    @Override
    public void run() {
        String s = threadLocalGet();
       // System.out.println(Thread.currentThread().getName() + " 拥有的字符串  " + s);
        synchronized (SplitContextDemo.class) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(" " + s.charAt(i));
            }
            stringThreadLocal.remove();
            System.out.println();
        }

    }

    public String threadLocalGet() {
        String str = stringThreadLocal.get();
        if (str == null || str.equals("")) {
            str = RandomUtil.randomString(8);
            stringThreadLocal.set(str);
        }
        return str;
    }

}
