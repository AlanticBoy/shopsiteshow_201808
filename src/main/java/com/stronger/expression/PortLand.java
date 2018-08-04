package com.stronger.expression;

import com.stronger.POJO.Persons;
import com.stronger.intertor.RevertItertor;
import org.junit.Test;

import java.util.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  16:17 2018/6/8
 * @ModefiedBy:
 */
public class PortLand {


    /*public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        RevertItertor<String> itertor = new RevertItertor<String>(list);
        Iterator<String> stringIterator = (Iterator<String>) itertor.revert();
    }
    */

    @Test
    public void testUser() {
        Persons persons = new Persons(1, "fusong", "heibei hengshui");
        persons.setId(50);
        persons.setName("fusong");
        Persons persons1 = new Persons(1, "fusong", "heibei hengshui");
        persons1.setName("fusong");
        persons1.setId(50);
        System.out.println(persons.equals(persons1));
        System.out.println("  hashcode    " + (persons.hashCode() == persons1.hashCode()));
        System.out.println(" persons=persons1 " + (persons == persons1));
        String str = "123";
        String ptr = "123";
        System.out.println(str.equals(ptr));
    }

    @Test
    public void testSet() {
        Set<Persons> set = new HashSet<Persons>();
        set.add(new Persons(1, "fusong", "heibei hengshui"));
        set.add(new Persons(1, "fusong", "heibei hengshui"));
        set.add(new Persons(1, "fusong", "heibei hengshui"));
        set.add(new Persons(1, "fusong", "heibei hengshui"));
        Iterator<Persons> iterator = set.iterator();
        while (iterator.hasNext()) {
            Persons persons = iterator.next();
            System.out.println(persons);
        }
    }

    @Test
    public void testSetString() {
        Set<String> set = new HashSet<String>();
        set.add("aaa");
        set.add("aaa");
        set.add("aaa");
        set.add("aaa");
        set.add("aaa");
        Iterator<String> iterator = set.iterator();
      while (iterator.hasNext()){
          System.out.print(" "+iterator.next());
      }
    }
}
