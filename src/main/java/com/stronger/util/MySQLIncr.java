package com.stronger.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.lang.ref.SoftReference;
import java.sql.SQLException;
import java.util.Random;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  22:15 2018/6/3
 * @ModefiedBy:
 */
public class MySQLIncr {

    public static void main(String[] args) {
        QueryRunner runner = null;

        ComboPooledDataSource dataSource = ConnectionUtil.getDataSource();
        String sql = "  INSERT into persons(name, address, sex, descs, workerAdd) VALUES (?,?,?,?,?)";
        int k=10000000;
        runner = new QueryRunner(dataSource);
        for (int i = 0; i < k; i++) {
            Object []params=new Object[]{RandomUtil.randomString(12), RandomUtil.randomString(12),"nan","handsome","zheng zhou,gaoxinqu"};
            try {
                runner.update(sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
