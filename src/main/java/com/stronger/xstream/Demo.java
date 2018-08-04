package com.stronger.xstream;

import com.stronger.io.bean.Person;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:27 2018/6/25
 * @ModefiedBy:
 */
public class Demo {

    class Person {
        private int id;
        private String name;
        private String age;

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        public Person(int id, String name, String age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    @Test
    public void testBean2Xml() {


        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1, "fu song", "nan"));
        personList.add(new Person(2, "fu yi", "nan"));
        personList.add(new Person(3, "song song", "nan"));
        personList.add(new Person(4, "yi yi", "nan"));


        XStream stream = new XStream();

        stream.alias("Person", Person.class);
        stream.setMode(XStream.NO_REFERENCES);
        String s = stream.toXML(personList);
        System.out.println(s);
        System.out.println("##########################################");
        XStream xStream = new XStream();
        xStream.alias("Person", Person.class);
        xStream.setMode(XStream.NO_REFERENCES);
        List<Person> list = (List<Person>) xStream.fromXML(s);
        System.out.println(list);
        System.out.println("##########################################");
    }


}
