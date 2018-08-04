package com.stronger.spring;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:38 2018/6/2
 * @ModefiedBy:
 */
public class Message {

    private String content;
    private String type;

    public void init() {
        System.out.println("  create message instance ");
    }

    public void destory() {
        System.out.println(" message instance destroy ");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
