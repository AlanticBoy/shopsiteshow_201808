package com.stronger.chain;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  17:51 2018/6/8
 * @ModefiedBy:
 */
public class OddLink {
    private class Node {
        public int data;//存放数据
        public Node next;//用于存放下一个节点

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;//定义一个头结点

    public OddLink() {
        head = null;
    }

    //把元素插入到第一个位置
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /*添加一个元素*/
    public void add(int data) {
        Node node = new Node(data);
        Node current = head;
        /*第一次添加元素时，若链表是空的让头结点等于该节点并返回*/
        if (head == null) {
            head = node;
            return;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
        }
        head = current;
    }

    /*在指定位置添加一个元素*/
    public void add(int index, int data) {
        Node node = new Node(data);
        int position = 0;
        Node current = head;
        while (position != index) {
            head = head.next;
            position++;
        }
        node.next = head.next;
        head.next = node;
        head = current;
    }

    /*删除并返回头结点*/
    public int deleteByFirst() {
        int result = head.data;
        head = head.next;
        return result;
    }

    public void deleteByIndex(int index) {
        Node current = head;
        int position = 0;
        while (position != index) {
            head = head.next;
            position++;
        }
        head.next = head.next.next;
        head = current;
    }

    public void display() {
        if (head == null) {
            throw new RuntimeException("链表数据不存在");
        }
        Node node = head;
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }
}
