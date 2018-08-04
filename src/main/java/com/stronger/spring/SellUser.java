package com.stronger.spring;

import java.util.Date;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  14:23 2018/7/14
 * @ModefiedBy:
 */
public class SellUser {
    private String name;
    private long time;
    private Date  date;

    @Override
    public String toString() {
        return "SellUser{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
