package com.stronger.xstream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  17:02 2018/6/27
 * @ModefiedBy:
 */
public class LibServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {

        }
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(" 中国 " + "<br>");
        writer.println("  request.getAuthType()  " + request.getAuthType() + "<br>");
        writer.println("   request.getRequestURI()  " + request.getRequestURI() + "<br>");
        writer.println("  request.getRequestURL()  " + request.getRequestURL() + "<br>");
        writer.println("  request.getServerPort()  " + request.getServerPort() + "<br>");
        writer.println("   request.getRemotePort() " + request.getRemotePort() + "<br>");
        writer.println("  request.getLocale()  " + request.getLocale() + "<br>");
        writer.println("  request.getContextPath()  " + request.getContextPath() + "<br>");
        writer.println("  request.getMethod()  " + request.getMethod() + "<br>");
        writer.println("  request.getPathInfo()  " + request.getPathInfo() + "<br>");
        writer.println("   request.getPathTranslated() " + request.getPathTranslated() + "<br>");
        writer.println("  request.getQueryString()  " + request.getQueryString() + "<br>");
        writer.println("  request.getReader()  " + request.getReader() + "<br>");
        writer.println("   request.getRequestedSessionId() " + request.getRequestedSessionId() + "<br>");
        writer.println("   request.getSession().getId()  " + request.getSession().getId() + "<br>");
        writer.println("  request.getRequestedSessionId() = = request.getSession().getId() ?  " + request.getSession().getId().equals(request.getRequestedSessionId()) + "<br>");
        writer.println("   request.getServerName()   " + request.getServerName() + "<br>");
        writer.println("  request.getCharacterEncoding()   " + request.getCharacterEncoding() + "<br>");
        writer.flush();*/
        /**
         * 1.获得客户机信息
         */
        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        String requestUri = request.getRequestURI();//得到请求的资源
        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("获取到的客户机信息如下：");
        out.write("<hr/>");
        out.write("请求的URL地址：" + requestUrl);
        out.write("<br/>");
        out.write("请求的资源：" + requestUri);
        out.write("<br/>");
        out.write("请求的URL地址中附带的参数：" + queryString);
        out.write("<br/>");
        out.write("来访者的IP地址：" + remoteAddr);
        out.write("<br/>");
        out.write("来访者的主机名：" + remoteHost);
        out.write("<br/>");
        out.write("使用的端口号：" + remotePort);
        out.write("<br/>");
        out.write("remoteUser：" + remoteUser);
        out.write("<br/>");
        out.write("请求使用的方法：" + method);
        out.write("<br/>");
        out.write("pathInfo：" + pathInfo);
        out.write("<br/>");
        out.write("localAddr：" + localAddr);
        out.write("<br/>");
        out.write("localName：" + localName);
        out.write("<br/>");
        out.write("所有的cookie数据");
        out.write("<br/>");
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            out.write("Cookie Name  " + cookie.getName() + "  Cookie Value  " + cookie.getValue());
            out.write("<br/>");
        }
    }
}
