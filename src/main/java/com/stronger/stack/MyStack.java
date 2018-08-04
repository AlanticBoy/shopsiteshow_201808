package com.stronger.stack;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  15:25 2018/6/8
 * @ModefiedBy:
 */
public class MyStack<T> extends Stack<T> {

    @Override
    public synchronized int search(Object o) {
        Object[] array = elementData;
        final int size = elementCount;
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(o)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public Enumeration<T> elements() {
        final Object array[] = elementData;
        return new Enumeration<T>() {
            int count = elementCount - 1;

            public boolean hasMoreElements() {
                return count >= 0;
            }

            public T nextElement() {
                synchronized (MyStack.class) {
                    return (T) array[count--];
                }
            }
        };
    }

    public static void main(String[] args) {
        Stack<String> strings = new Stack<String>();
        List<String> stringList = new ArrayList<String>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        stringList.add("ddd");
        strings.addAll(stringList);
        strings.add("www");
        strings.add("xxx");
        strings.add("yyy");
        strings.add("zzz");

        System.out.println(" whose position is " + strings.search("ccc"));
       /* System.out.println("  "+strings.get(0));
        System.out.println("  "+strings.get(2));
        System.out.println("  "+strings.pop());
        System.out.println("  "+strings.pop());*/
        /**/

    }
}
