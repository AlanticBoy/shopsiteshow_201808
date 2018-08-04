package com.stronger.divide;

import com.stronger.util.ConnectionUtil;
import com.stronger.util.RandomUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:49 2018/6/5
 * @ModefiedBy:
 */
public class PartitionDivide {

    private static Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(1, "users_01");
        put(2, "users_02");
        put(3, "users_03");
    }};

    public static void main(String[] args) {
        QueryRunner runner = new QueryRunner(ConnectionUtil.getDataSource());
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i < 20; i++) {
            buffer.append("insert into ");
            int num=RandomUtil.randomInt(1,3);
            buffer.append(map.get(num));
            System.out.println(" num "+num);
            buffer.append("(phone,email,name)values(?,?,?)");
            Object []params=new Object[]{RandomUtil.randomNumberString(11),RandomUtil.randomString(11),RandomUtil.randomString(8)};
            try {
                runner.update(buffer.toString(),params);
                buffer.setLength(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
