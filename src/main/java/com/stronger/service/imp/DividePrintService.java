package com.stronger.service.imp;

import com.stronger.service.PrintService;
import org.springframework.stereotype.Service;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:27 2018/7/14
 * @ModefiedBy:
 */
@Service
public class DividePrintService implements PrintService {
    @Override
    public void print(String content) {
        for (int i=0;i<content.length();i++){
            System.out.print(" "+content.charAt(i));
        }
        System.out.println();
    }
}
