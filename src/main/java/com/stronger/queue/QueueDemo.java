package com.stronger.queue;

import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.*;


/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  16:59 2018/6/8
 * @ModefiedBy:
 */
public class QueueDemo {

    @Test
    public void test1() {
        Queue<String> queue = new LinkedList<String>();
        String str[]=new String[3];
        str[0]="fu song";
        str[1]="fu yi";
        str[2]=" yi yi";

        str= Arrays.copyOf(str,str.length*2);
        System.out.println(" new length "+str.length);
        System.out.print(Arrays.toString(str));

    }

}
