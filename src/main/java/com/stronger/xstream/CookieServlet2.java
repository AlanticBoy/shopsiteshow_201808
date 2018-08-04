package com.stronger.xstream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:54 2018/6/28
 * @ModefiedBy:
 */
public class CookieServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        String type = "type1=innocent&type2=pure";
        Cookie cookie = new Cookie("type", type);
        cookie.setMaxAge(10 * 60 * 24);
        cookie.setPath("/");
        /*------------------Recore LastAccessTime------------------*/

        Cookie cookies[] = req.getCookies();
        String lastAccessTime = "";
        for (Cookie cookie1 : cookies) {
            if (cookie1.getName().equals("lastAccessTime")) {
                lastAccessTime = cookie1.getValue();
            }
        }
        if ((lastAccessTime.equals(""))||(lastAccessTime==null)){

        }else {
            resp.getWriter().write(" 上次访问时间  "+lastAccessTime);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm hh:mm:ss");
        String date = sdf.format(new Date());
        Cookie cookie2 = new Cookie("lastAccessTime", date);
        resp.addCookie(cookie);
        resp.addCookie(cookie2);

    }
}
