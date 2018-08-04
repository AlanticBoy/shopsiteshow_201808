package com.stronger.chain;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  18:00 2018/6/8
 * @ModefiedBy:
 */
public class LinkDemo {


    /*public static void main(String[] args) {
        try {
            Class clazz=Class.forName("java.util.LinkedList");
            for (Method method:clazz.getMethods()){
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
   /* public static void main(String[] args) {
        OddLink oddLink = new OddLink();
        oddLink.add(1);
        oddLink.add(2);
        oddLink.add(3);
        oddLink.add(4);
        oddLink.add(2, 6);
        oddLink.clear();
        oddLink.display();
    }*/

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        doubleLink.insertAtHeader(5);
        doubleLink.insertAtHeader(4);
        doubleLink.insertAtHeader(3);
        doubleLink.insertAtHeader(2);
        doubleLink.deleteAtHeader();
        doubleLink.deleteAtTail();
        doubleLink.display();
    }

}
