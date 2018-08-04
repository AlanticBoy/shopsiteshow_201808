package com.stronger.POJO;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  22:36 2018/6/6
 * @ModefiedBy:
 */
public class Peros {
    private String name;
    private String address;
    private String sex;
    private String descs;
    private String workAdd;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescs() {
        return descs;
    }

    @Override
    public String toString() {
        return "Peros{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", descs='" + descs + '\'' +
                ", workAdd='" + workAdd + '\'' +
                '}';
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getWorkAdd() {
        return workAdd;
    }

    public void setWorkAdd(String workAdd) {
        this.workAdd = workAdd;
    }

}
