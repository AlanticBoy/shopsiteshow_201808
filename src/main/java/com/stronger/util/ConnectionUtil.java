package com.stronger.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.scenario.effect.impl.prism.PrImage;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  22:02 2018/6/3
 * @ModefiedBy:
 */
public class ConnectionUtil {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "fusong";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/managemrnt";

    private static Connection connection = null;

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getDataSource() {
        try {
            dataSource.setJdbcUrl(URL);
            dataSource.setDriverClass(DRIVER_NAME);
            dataSource.setUser(USERNAME);
            dataSource.setPassword(PASSWORD);
            /*最多有多少个连接 */
            dataSource.setMaxPoolSize(200);
            /*如果池中数据连接不够时一次增长多少个*/
            dataSource.setAcquireIncrement(10);
            /*初始化池大小*/
            dataSource.setInitialPoolSize(10);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
