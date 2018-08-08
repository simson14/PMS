package com.widetns.framework.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class RequestMdcFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            // Setup MDC data:
//            String mdcData = String.format("[userId:%s | url:%s] ", "test", ((HttpServletRequest)servletRequest).getRequestURL());
//            todo : 로그인 기능 완료시 변경 필요
            MDC.put("user", "test"); //Variable 'mdcData' is referenced in Spring Boot's logging.pattern.level property
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            // Tear down MDC data:
            // ( Important! Cleans up the ThreadLocal data again )
            MDC.clear();
        }
    }

    @Override
    public void destroy() {

    }
}
