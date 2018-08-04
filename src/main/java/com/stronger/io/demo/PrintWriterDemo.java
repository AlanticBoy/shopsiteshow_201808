package com.stronger.io.demo;

import com.stronger.io.bean.Person;
import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.omg.PortableInterceptor.ObjectReferenceTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  10:13 2018/6/25
 * @ModefiedBy:
 */
public class PrintWriterDemo {
    @Test
    public void testReadMe() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\Hello.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Third.txt"));
            byte[] bytes = new byte[512];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class OOMObject {

          private   Integer[] array = new Integer[10000];

    }

    @Test
    public void testOOM() {
        List<OOMObject> oomObjects = new ArrayList<OOMObject>();
        int len = 0;
        while (true) {
            System.out.println(" len= " + len++);
            oomObjects.add(new OOMObject());
        }
    }

    @Test
    public void testReadTxt() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\AAA.doc"), "gbk"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\BBB.doc"), "gbk"));
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4() {
        try {

            PrintWriter writer = new PrintWriter("PrintWriterDemo.txt");
            writer.println("Hello,PrintWrietr");
            writer.flush();
            FileInputStream stream = new FileInputStream("PrintWriterDemo.txt");
            byte[] bytes = new byte[32];
            int len = 0;
            /*stream.read(byte [])方法一次读取byte数组长度的的字节，
            并且把读的数据填充到字节数组
            */
            while ((len = stream.read(bytes)) != -1) {
                System.out.println(len);
                String str = new String(bytes, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        try {

            PrintWriter writer = new PrintWriter("PrintWriterDemo.txt");
            writer.println("Hello,PrintWrietr");
            writer.flush();
            FileInputStream stream = new FileInputStream("PrintWriterDemo.txt");
            byte[] bytes = new byte[512];
            while ((stream.read(bytes, 0, bytes.length)) > 0) {
                System.out.println(bytes.length);
                String str = new String(bytes);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setId(1);
        person.setName("fu song ");
        person.setSex("nan");

        byte[] bytes = serize(person);
        Person person1 = deserize(bytes, new Person());
        System.out.println(person1);
    }

    public static byte[] serize(Person person) {
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(person);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    public static <T> T deserize(byte[] bytes, T t) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream ois = new ObjectInputStream(bis);
            t = (T) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Test
    public void test3() {
        System.out.println(6 ^ 3 ^ 3);
        System.out.println(4 << 3);
        System.out.println(168 >> 4);
        System.out.println(168 >>> 4);
    }
}
