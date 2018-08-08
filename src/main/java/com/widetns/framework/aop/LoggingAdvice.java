package com.widetns.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;


@Slf4j
@Aspect
@Component
public class LoggingAdvice extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("====================================================================================");
        log.info("RequestURL = " + request.getRequestURL());
        return super.preHandle(request, response, handler);
    }

    @Before("execution(* com.widetns.test..*.*(..))")
    private void loggingParameters(JoinPoint point) {
        Object[] objs = point.getArgs();

        StringBuilder sb = new StringBuilder(100);
        for (Object arg : objs) {
            if (arg instanceof HttpServletRequest) {
                for (Object key : ((HttpServletRequest) arg).getParameterMap().keySet()) {
                    sb.append(key).append(" = ").append(((HttpServletRequest) arg).getParameter(key.toString())).append(", ");
                }
            } else if (arg instanceof LinkedHashMap) {
                for (Object key : ((LinkedHashMap) arg).keySet()) {
                    sb.append(key).append(" = ").append(((LinkedHashMap) arg).get(key)).append(", ");
                }
            } else if (arg instanceof HashMap) {
                for (Object key : ((HashMap) arg).keySet()) {
                    sb.append(key).append(" = ").append(((HashMap) arg).get(key)).append(", ");
                }
            } else if (arg instanceof String) {
                sb.append(arg).append(", ");

            }
        }
        if (!sb.toString().equals("")) {
            log.info("Parameters = { " + sb.toString().substring(0, sb.toString().length() - 2) + " } ");
        }
    }

    @Around("execution(* com.widetns.test..*.*(..))")
    public Object loggingExcutionTime(ProceedingJoinPoint point) throws Throwable {

        Object obj;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        obj = point.proceed();
        stopWatch.stop();
        log.info("ExecutionTime = " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "() " + stopWatch.getTotalTimeMillis() + " msec ");
        return obj;
    }

}
