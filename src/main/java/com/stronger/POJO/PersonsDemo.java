package com.stronger.POJO;

import com.stronger.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  12:02 2018/6/4
 * @ModefiedBy:
 */
public class PersonsDemo {

    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "select * from persons limit 0,30";
        List<Persons> personsList = new ArrayList<Persons>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Persons persons=null;
            while (resultSet.next()) {
                persons= new Persons();
                persons.setId(resultSet.getInt("id"));
                persons.setName(resultSet.getString("name"));
                persons.setSex(resultSet.getString("sex"));
                persons.setDescs(resultSet.getString("descs"));
                persons.setWorkAdd(resultSet.getString("workerAdd"));
                personsList.add(persons);
            }
            for (Persons persons1:personsList){
                System.out.println(persons1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
