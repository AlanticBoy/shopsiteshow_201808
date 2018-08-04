package com.stronger.io.demo;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  15:40 2018/6/25
 * @ModefiedBy:
 */
public class IoBufferedStream{

    public static void main(String[] args) {
        String urladdress = "http://www.madore.org/~david/math/padics.pdf";
        String filename = "F:\\padics.pdf";
        new IoBufferedStream().downloadNet(urladdress,filename);

    }
    public void downloadNet(String urladdress,String filename) {
        //以缓冲流的方式读写网络文件
        int byteread = 0;//记录读取的长度
        URL url = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            url = new URL(urladdress);
            URLConnection conn = url.openConnection();
            is = conn.getInputStream();
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[512];
            while ((byteread = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, byteread);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
