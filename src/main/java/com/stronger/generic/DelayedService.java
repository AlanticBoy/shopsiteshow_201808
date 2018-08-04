package com.stronger.generic;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:16 2018/6/17
 * @ModefiedBy:
 */
public class DelayedService<T extends Service<? extends T>> {
    Service<? extends T> service;

}
