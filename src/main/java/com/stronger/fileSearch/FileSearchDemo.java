package com.stronger.fileSearch;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:57 2018/6/18
 * @ModefiedBy:
 */
public class FileSearchDemo {

    public static void main(String[] args) {
        BlockingQueue<File> blockingQueue=new ArrayBlockingQueue<File>(5);
        new Thread(new EnumFileTask(blockingQueue,new File("E:\\lucene"))).start();
        for (int i=0;i<5;i++){
            new Thread(new SearchTask(blockingQueue,"kindness")).start();
        }
    }
}
