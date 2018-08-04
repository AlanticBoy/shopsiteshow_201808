package com.stronger.fileSearch;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:57 2018/6/18
 * @ModefiedBy:
 */
public class SearchTask implements Runnable {
    private BlockingQueue<File> blockingQueue;
    private String keyWord;

    public SearchTask(BlockingQueue<File> blockingQueue, String keyWord) {
        this.blockingQueue = blockingQueue;
        this.keyWord = keyWord;
    }


    @Override
    public void run() {
        try {
            while (true){
                /*System.out.println(Thread.currentThread().getName()+" 在等待 ");*/
                File file = blockingQueue.take();
                String content=IOUtils.toString(new FileInputStream(file));
                if (content.indexOf(keyWord)>0){
                    System.out.println(file.getPath());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
