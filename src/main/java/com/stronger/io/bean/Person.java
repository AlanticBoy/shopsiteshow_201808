package com.stronger.io.bean;

import java.io.Serializable;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  10:13 2018/6/25
 * @ModefiedBy:
 */
public class Person implements Serializable{

    private int id;
    private String name;
    private String sex;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
