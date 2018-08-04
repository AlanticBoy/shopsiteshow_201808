package com.stronger.thread;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:32 2018/6/6
 * @ModefiedBy:
 */
public class PrintString implements Runnable {

    private String str;

    public PrintString(String str) {
        this.str = str;
    }

    public void run() {
      for (int i=0;i<str.length();i++){
          System.out.print(" "+str.charAt(i));
      }
        System.out.println(" ");
    }
}
