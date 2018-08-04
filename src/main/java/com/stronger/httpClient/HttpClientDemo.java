package com.stronger.httpClient;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  18:33 2018/6/28
 * @ModefiedBy:
 */
public class HttpClientDemo {

    @Test
    public void test2() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/static_login/images/login-bg.jpg");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            FileUtils.copyInputStreamToFile(entity.getContent(), new File("D://login.jpg"));
            //System.out.println(EntityUtils.toString(entity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        我们在这边用最简单的测试请求github.com是可以请求到数据的。
        但是有些网站进行了设置，比如tuicool。非代理浏览器是不恩能够访问的，这时需要加请求头来模拟浏览器访问*/
    @Test
    public void test1() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.tuicool.com/");
        /*加了httpGet.setHeader可以模拟浏览器对该网址进行访问*/
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; W…) Gecko/20100101 Firefox/61.0");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/user/getData.action");
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        /*创建参数队列*/
        List<NameValuePair> valuePairList = new ArrayList<NameValuePair>();
        valuePairList.add(new BasicNameValuePair("num", "1"));
        valuePairList.add(new BasicNameValuePair("name", "fu song"));
        valuePairList.add(new BasicNameValuePair("age", "20"));
        CloseableHttpResponse response = null;
        try {

            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairList, "utf-8");
            httpPost.setEntity(formEntity);
            response = client.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content: " + EntityUtils.toString(httpEntity, "UTF-8"));
                System.out.println("--------------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
