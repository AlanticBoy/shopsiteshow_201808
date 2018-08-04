package com.stronger.fileSearch;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:57 2018/6/18
 * @ModefiedBy:
 */
public class EnumFileTask implements Runnable {

    private BlockingQueue<File> blockingQueue;

    private File dirctory;

    public EnumFileTask(BlockingQueue<File> blockingQueue, File dirctory) {
        this.blockingQueue = blockingQueue;
        this.dirctory = dirctory;
    }

    @Override
    public void run() {
        enumFiles(dirctory);
    }

    public void enumFiles(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
           /* System.out.println(" bian li file "+file.getName());*/
            if (file.isDirectory()) {
                enumFiles(file);
            } else {
                try {
                    blockingQueue.put(file);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
