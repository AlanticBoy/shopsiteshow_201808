package com.stronger.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  19:10 2018/6/12
 * @ModefiedBy:
 */
public class TraceHandler<T> implements InvocationHandler {
    private T t;

    public TraceHandler(T t) {
        this.t = t;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(" current executing method " + method);
        System.out.println(" args are lists: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print("  " + args[i]);
        }
        System.out.println();
        return method.invoke(t, args);
    }
}
