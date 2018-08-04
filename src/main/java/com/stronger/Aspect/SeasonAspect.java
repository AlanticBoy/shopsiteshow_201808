package com.stronger.Aspect;

import com.stronger.util.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:18 2018/7/16
 * @ModefiedBy:
 */
@Component
@Aspect
public class SeasonAspect {
    /*单纯地给AspectController里的spring方法做切面*/
//    public static final String POINT_METHOD_SPRING = "execution(* com.stronger.controller.AspectController.spring(..))";
    /*给AspectController里的所有方法做切面*/
    public static final String POINT_METHOD = "execution(* com.stronger.controller.AspectController.*(..))";

    @Pointcut(POINT_METHOD)
    public void decalreSeasonMethod() {
    }


    @Before("decalreSeasonMethod()")
    public void beforeMethod(JoinPoint joinPoint) throws UnsupportedEncodingException {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) ra).getResponse();
        System.out.println(" 执行到这一步 ");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
    }

    @AfterReturning(returning = "rvt", pointcut = "decalreSeasonMethod()")
    public Object aroundMethod(Object rvt) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("  AfterReturning增强：获取目标方法的返回值：      " + rvt);
        return rvt;
    }


}
