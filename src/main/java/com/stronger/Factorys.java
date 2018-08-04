package com.stronger;

import com.stronger.POJO.Peros;
import com.stronger.POJO.PersonInfo;
import com.stronger.POJO.Persons;
import com.stronger.classes.TalkingConstants;
import com.stronger.intertor.RevertItertor;
import com.stronger.service.imp.DividePrintService;
import com.stronger.service.imp.NamePrintService;
import com.stronger.spring.SellUser;
import com.stronger.spring.ServiceQuest;
import com.stronger.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ForkJoinPoolFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:41 2018/6/6
 * @ModefiedBy:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext_beans.xml")
public class Factorys {


    @Autowired
    private DividePrintService dividePrintService;

    @Autowired
    private NamePrintService namePrintService;

    @Autowired
    private ServiceQuest serviceQuest;
    @Test
    public void testService() {
       dividePrintService.print("Mom,fu chou yi");
       namePrintService.print("fu chou yi");
    }


    @Autowired
    private SellUser sellUser;


    @Test
    public void testWithMock(){
     serviceQuest.printService("dad");
        System.out.println("--------------------------------");
        System.out.println(sellUser);
    }
    @Test
    public void testStr() {
        String str = "+";
        System.out.println(str.charAt(0));
    }

    @Test
    public void testPrtint() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.stronger.POJO.Persons");
        System.out.println(" which classLoader " + clazz.getClassLoader());
        System.out.println(" CanonicalName  " + clazz.getCanonicalName());
        System.out.println("  which class  " + clazz.getClass());
        System.out.println(" simpleName  " + clazz.getSimpleName());
        System.out.println(" supreclass  " + clazz.getSuperclass());
        Persons persons = (Persons) clazz.newInstance();
    }

    @Test
    public void testPrit() throws IllegalAccessException, InstantiationException {
        Persons persons = new Persons(1, "fusong", "heibei hengshui");
        System.out.println(" first " + persons.hashCode());
        Class clazz = persons.getClass();
        Persons persons1 = (Persons) clazz.newInstance();
        System.out.println(" second  " + persons1.hashCode());
    }


    @Test
    public void testClazz() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        //获取所有构造函数
        Constructor<?>[] cons = cls.getConstructors();
        //循环打印
        for (int i = 0; i < cons.length; i++) {
            System.out.println(cons[i]);
        }

    }

    @Test
    public void testPeros() throws IllegalAccessException, InstantiationException {
        Class<?> clazz = Peros.class;
        Peros persons = (Peros) clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

           /* Field field1= (Field) field.get(field.getName());

            String val=RandomUtil.randomString(5);
            System.out.println(" fieldName "+field.getName()+" val "+val);
            field1.set(persons, val);*/
            field.set(persons, RandomUtil.randomNumberString(5));
        }
        System.out.println("---------------------------------");
        System.out.println(persons);
    }

    @Test
    public void testApplicationContext() {
        try {
            Class clazz = Class.forName("org.springframework.context.ApplicationContext");
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {


    }

    @Test
    public void testVo() {

        PersonInfo[] infos = new PersonInfo[6];
        infos[0] = new PersonInfo(1, " fu song", "nan");
        infos[1] = new PersonInfo(2, " a yi", "nan");
        infos[2] = new PersonInfo(3, " chen hao nan", "nan");
        infos[3] = new PersonInfo(4, " shan ji", "nan");
        infos[4] = new PersonInfo(5, " da fei", "nan");
        infos[5] = new PersonInfo(6, " tong luo wang", "nan");
        for (PersonInfo info : infos) {
            System.out.println(info);
        }
        System.out.println("##########################################");
        Arrays.sort(infos);
        for (PersonInfo info : infos) {
            System.out.println(info);
        }

    }

    @Test
    public void testClass() {

    }

    @Test
    public void testReflection() {
        try {
            Class clazz = Class.forName("com.stronger.POJO.Persons");
            Persons persons = (Persons) clazz.newInstance();
            Field fields[] = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals("id")) {
                    field.set(persons, RandomUtil.randomInt(11, 30));
                } else {
                    field.set(persons, RandomUtil.randomString(8));
                }
            }
            System.out.println("  " + persons);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObject() {
        try {
            Class clazz = Class.forName("java.lang.String");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            Constructor constructors[] = clazz.getDeclaredConstructors();

            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        List<String> list = new LinkedList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println("  " + list.get(0));
    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<String>();
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("string  " + iterator.next());
        }
    }


    @Test
    public void test3() {
        List<String> list = new LinkedList<String>();
        Object o = new Object();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for (String s : list) {
            System.out.print("  " + s);
        }
    }


}
