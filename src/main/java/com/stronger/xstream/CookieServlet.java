package com.stronger.xstream;

import com.sun.jmx.snmp.SnmpString;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  22:19 2018/6/27
 * @ModefiedBy:
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        String info = "name=fusong age=15";
        Cookie cookie = new Cookie("info", info);
        cookie.setMaxAge(10 * 60 * 24);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }
}
