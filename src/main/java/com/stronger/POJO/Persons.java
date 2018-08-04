package com.stronger.POJO;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  12:00 2018/6/4
 * @ModefiedBy:
 */
public class Persons {

    private int id;
    private String name;
    private String address;
    private String sex;
    private String descs;
    private String workAdd;

    public Persons(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    static {
        System.out.println(" loading Persons ");
    }
    {
        System.out.println(" conducting Persons ");
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

    @Override
    public int hashCode() {
        return Objects.hash(name,address);
    }

    @Override
    public boolean equals(Object obj) {

        return (this.id==((Persons)obj).id)&&(this.name==((Persons)obj).name);
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

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getWorkAdd() {
        return workAdd;
    }

    public void setWorkAdd(String workAdd) {
        this.workAdd = workAdd;
    }

    public Persons() {
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", descs='" + descs + '\'' +
                ", workAdd='" + workAdd + '\'' +
                '}';
    }
}
