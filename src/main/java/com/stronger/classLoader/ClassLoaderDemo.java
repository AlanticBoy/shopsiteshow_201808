package com.stronger.classLoader;

import org.springframework.test.context.BootstrapContext;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;

import java.net.URLClassLoader;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  18:56 2018/6/11
 * @ModefiedBy:
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(loader.toString());
        System.out.println(loader.getParent().toString());
        System.out.println(loader.getParent().getParent().toString());
    }
}
