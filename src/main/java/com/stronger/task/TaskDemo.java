package com.stronger.task;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  22:30 2018/6/5
 * @ModefiedBy:
 */
public class TaskDemo {
    private static List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
    private static Timer timer = new Timer();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "fu song");
        map.put("email", "172536");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "fu yi");
        map2.put("email", "52368");

        timer.schedule(new MyTask(mapList),2000,2000);
        while (true) {
            mapList.add(map);
            mapList.add(map2);
            System.out.println(" current seconds   " + new Date().getSeconds());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
