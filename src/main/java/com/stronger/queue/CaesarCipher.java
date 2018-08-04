package com.stronger.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  15:57 2018/6/10
 * @ModefiedBy:
 */
public class CaesarCipher {

    public static void main(String[] args) {
        StringBuilder encode = new StringBuilder();
        StringBuilder decode = new StringBuilder();
        int key[] = {2, 3, 6, 5, 1, 8};
        Queue<Integer> enqueue = new LinkedList<Integer>();
        Queue<Integer> dequeue = new LinkedList<Integer>();
        String message = "Hello,tomorrow";
        for (int aKey : key) {
            enqueue.add(aKey);
            dequeue.add(aKey);
        }

        for (int i = 0; i < message.length(); i++) {
            int keyVal = enqueue.remove();
            encode.append((char) (message.charAt(i) + keyVal));
            enqueue.add(keyVal);
        }
        System.out.println("  encode message " + encode);
        for (int i = 0; i < encode.length(); i++) {
            int keyVal = dequeue.remove();
            decode.append((char) (encode.charAt(i) - keyVal));
            dequeue.add(keyVal);
        }
        System.out.println("  decode  " + decode);
    }

}
