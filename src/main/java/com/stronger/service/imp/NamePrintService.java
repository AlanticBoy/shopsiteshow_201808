package com.stronger.service.imp;

import com.stronger.service.PrintService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.SqlConfig;

import javax.sql.DataSource;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:26 2018/7/14
 * @ModefiedBy:
 */
@Service
public class NamePrintService implements PrintService {
    @Override
    public void print(String content) {
        System.out.println("  "+content);
    }
}
