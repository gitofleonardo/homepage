package cn.huangchengxi.homepage.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(cn.huangchengxi.homepage.aop.Action)")
    public void annotationPointCut(){
    }
    @Before("execution(* cn.huangchengxi.homepage.controller.LoginController.*(..))")
    public void before(JoinPoint joinPoint) throws IOException {
        ServletRequestAttributes attrs= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attrs.getRequest();
        System.out.println(request.getRequestURI()+request.getRemoteHost());
        HttpServletResponse response=attrs.getResponse();
        //response.sendRedirect("/error");
    }
}
