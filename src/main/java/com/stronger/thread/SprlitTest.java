package com.stronger.thread;

import com.stronger.util.RandomUtil;
import org.junit.Test;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  19:10 2018/6/17
 * @ModefiedBy:
 */
public class SprlitTest {

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(new SplitContextDemo()).start();
        }
    }
}
