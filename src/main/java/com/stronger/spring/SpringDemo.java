package com.stronger.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:41 2018/6/2
 * @ModefiedBy:
 */
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext_beans.xml")
*/

public class SpringDemo {

    /*
        @Autowired
        private Message message;

        @Test
        public void test1() {
            message.getContent();
        }
    */
    private static int abc = 100;


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext_beans.xml");
        Message message = (Message) context.getBean("message");
        System.out.println(message.getContent());

    }


}
