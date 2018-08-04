package com.stronger.xstream;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  14:06 2018/6/29
 * @ModefiedBy:
 */
public class JAXB_Test {


    @XmlRootElement(name = "People")
    static class People {
        @XmlElement(name = "NAME")
        public String name;
        @XmlElement(name = "AGE")
        public int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        People people = new People();
        people.name = "闪电";
        people.age = 18;
        String xml = JAXBUtils.object2Xml(people);
        System.out.println(xml);

        People people1 = JAXBUtils.xml2Object(xml, People.class);
        System.out.println(people1);
    }
}
