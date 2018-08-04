package com.stronger.xstream;

import com.stronger.controller.entity.User;
import com.stronger.util.JedisUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:47 2018/6/28
 * @ModefiedBy:
 */
//@WebFilter(urlPatterns = "/*", filterName = "login")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        System.out.println(" request URI  " + request.getRequestURI());
        System.out.println(" request URL  " + request.getRequestURL());
        request.setCharacterEncoding("utf-8");
        if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".jpg")
                || url.endsWith(".gif") || url.endsWith(".png") || url.endsWith("/index.jsp")
                || url.endsWith("/userlogin.jsp") || url.endsWith("/login.action")
                || url.endsWith("phoneCheck.action") || url.endsWith("/registUser.action") || url.endsWith("registUser.action")
                || url.endsWith("resetPassword.action") || url.endsWith("goPaymentSucessPage.action")) {
            System.out.println(" 请求无限循环重定向");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("  current user  " + user);
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/20180526_demo/jsp/userlogin.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println(" destroy ");
    }
}
