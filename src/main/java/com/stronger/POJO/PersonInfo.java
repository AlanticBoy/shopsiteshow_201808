package com.stronger.POJO;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:20 2018/6/11
 * @ModefiedBy:
 */
public class PersonInfo implements Comparable<PersonInfo> {
    private int id;
    private String name;
    private String address;
    private String sex;

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
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

    public PersonInfo(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int compareTo(PersonInfo o) {
        return this.name.compareTo(o.getName());
    }
}
