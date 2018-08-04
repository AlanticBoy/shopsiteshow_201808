package com.stronger.xstream;

import javax.servlet.http.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:49 2018/6/27
 * @ModefiedBy:
 */
public class SessionListener implements HttpSessionListener {


    AtomicInteger count = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        count.getAndIncrement();
        session.setAttribute("onLineConnt", count);
        System.out.println("  sessionCreated    .......... where sessionId =   " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        count.decrementAndGet();
        session.setAttribute("onLineConnt", count);
        System.out.println("sessionDestroyed        ............ where sessionId =   " + session.getId());
    }
}
