package com.stronger.chain;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  12:06 2018/6/10
 * @ModefiedBy:
 */
public class DoubleLink {

    private class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node header;
    private Node tail;

    /*每次插入到头部*/
    public void insertAtHeader(int data) {
        Node node = new Node(data);
        if (header == null) {
            tail = node;
        } else {
            header.prev = node;
            node.next = header;
        }
        header = node;
    }

    /*插入到尾部*/
    public void insertAtTail(int data) {
        Node node = new Node(data);
        if (header == null) {
            header = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    /*判断是否为空*/
    public boolean isEmpty() {
        return header == null;
    }

    /*
    删除头结点，要进行两步操作，删除两个指针。
    一个是头节点的下一个节点，的前节点置为空。
    一个是让头结点指向下一个节点*/
    public void deleteAtHeader() {
        if (header == null) {
            throw new RuntimeException("链表数据不存在");
        }
        /*如果只有一个节点*/
        if (header.next == null) {
            tail = null;
        } else {
            header.next.prev = null;
        }
        header = header.next;
    }

    public void deleteAtTail() {
        if (header == null) {
            throw new RuntimeException("链表数据不存在");
        }
        if (header.next == null) {
            tail = null;
            header = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
    }

    public void display() {
        if (header == null) {
            throw new RuntimeException("链表数据不存在");
        }
        Node current = header;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
    }

}
