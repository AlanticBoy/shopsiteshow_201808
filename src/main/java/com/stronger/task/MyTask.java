package com.stronger.task;

import com.stronger.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  22:21 2018/6/5
 * @ModefiedBy:
 */
public class MyTask extends TimerTask {

    private static QueryRunner runner = new QueryRunner(ConnectionUtil.getDataSource());
    private List<Map<String, String>> mapList;

    public MyTask(List<Map<String, String>> mapList) {
        this.mapList = mapList;
    }

    public void run() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into user(phone,email,name) values");
        for (Map<String, String> map : mapList) {
            buffer.append("(");
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String val = map.get(key);
                System.out.println(" key  "+key+" val" +val);
                buffer.append(val + ",");
            }
            buffer.deleteCharAt(buffer.lastIndexOf(","));
            buffer.append("),");
        }
        buffer.deleteCharAt(buffer.lastIndexOf(","));
        System.out.println(buffer.toString());
        mapList.clear();
    }
}
