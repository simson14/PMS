package com.widetns.framework;

import com.widetns.framework.aop.LoggingAdvice;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@SpringBootApplication
@MapperScan("com.widetns")
@ComponentScan("com.widetns")
@EnableAspectJAutoProxy
public class DefaultApplication implements WebMvcConfigurer {

    @Autowired
    LoggingAdvice loggingAdvice;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingAdvice).addPathPatterns("/**/*");
    }


}
