package com.stronger.spring;

import com.stronger.service.PrintService;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:49 2018/7/14
 * @ModefiedBy:
 */

public class ServiceQuest {

    private PrintService printService;
    public ServiceQuest(PrintService printService) {

        this.printService = printService;
    }

    public void printService(String con){
        printService.print(con);

    }
}
