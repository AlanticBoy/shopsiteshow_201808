package com.stronger.hemowork;

import com.stronger.util.RandomUtil;


import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:10 2018/6/29
 * @ModefiedBy:
 */
public class Main {

    static class Teacher implements Serializable {
        private String firstName;
        private String lastName;
        private String level;
        private Double salary;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLevel() {
            return level;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", level='" + level + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
    }

    public static class RandomUtils {

        public static int randomInt(int min, int max) {
            return (int) (min + Math.random() * (max - min));
        }

        public static int randomInt(int num) {
            return new Random().nextInt(3);
        }

        public static double randomDouble(double min, double max) {
            return (min + Math.random() * (max - min));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher = null;
        String level[] = {"assistant", "associate", "full"};
        int levelNum = 0;
        double salary = 0.0;
        List<Teacher> teacherList = new ArrayList<Teacher>();
        for (int i = 1; i <= 1000; i++) {
            teacher = new Teacher();
            teacher.setFirstName("FirstName" + i);
            teacher.setLastName("LastName" + i);
            levelNum = RandomUtils.randomInt(3);
            teacher.setLevel(level[levelNum]);
            if (teacher.getLevel().equals("assistant")) {
                salary = RandomUtils.randomDouble(50000, 80000);
            } else if (teacher.getLevel().equals("associate")) {
                salary = RandomUtils.randomDouble(60000, 110000);
            } else {
                salary = RandomUtils.randomDouble(75000, 130000);
            }
            teacher.setSalary(Double.valueOf(new DecimalFormat("#.00").format(salary)));
            teacherList.add(teacher);
        }
        writeToFile(teacherList);
        List<Teacher> teachers = getFromFile("D://teacher.txt");
        //定义每个类别的总薪水，平均薪水，职工数
        Double associteSalary=0.0;
        double assistantSalary=0.0;
        double fullSalary=0.0;

        int associteCounts=0;
        int assistantCounts=0;
        int fullCounts=0;

        for (Teacher teacher1 : teachers) {
            if (teacher1.getLevel().equals("assistant")){
             assistantSalary+=teacher1.getSalary();
              assistantCounts++;
            }else if (teacher1.getLevel().equals("associate")){
                associteSalary+=teacher1.getSalary();
                associteCounts++;
            }else {
                fullSalary+=teacher1.getSalary();
                fullCounts++;
            }
        }
        DecimalFormat salaryFomat=new DecimalFormat("########.00");

        DecimalFormat df=new DecimalFormat("#.00");
        System.out.println(" 助理教授的总薪水 "+salaryFomat.format(assistantSalary)+" 平均薪水 "+df.format(assistantSalary/assistantCounts)+" 职工数  "+assistantCounts);
        System.out.println(" 副教授的总薪水 "+salaryFomat.format(associteSalary)+" 平均薪水 "+df.format(associteSalary/associteCounts)+" 职工数  "+associteCounts);
        System.out.println(" 正教授授的总薪水 "+salaryFomat.format(fullSalary)+" 平均薪水 "+df.format(fullSalary/fullCounts)+" 职工数  "+fullCounts);

    }

    public static List<Teacher> getFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(fileName));
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (List<Teacher>) ois.readObject();
    }

    public static void writeToFile(List<Teacher> teacherList) throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream(new File("D://teacher.txt"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(teacherList);
        oos.close();
        byte b[] = bos.toByteArray();
        fos.write(b);
        fos.flush();
        fos.close();
    }


}
