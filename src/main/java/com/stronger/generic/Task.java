package com.stronger.generic;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:21 2018/6/17
 * @ModefiedBy:
 */
public class Task implements Runnable {

    private String content;

    public Task(String content) {
        this.content = content;
    }

    public void run() {
        for (int i = 0; i < content.length(); i++) {
            System.out.print(" " + content.charAt(i));
        }
        System.out.println();
    }

}
