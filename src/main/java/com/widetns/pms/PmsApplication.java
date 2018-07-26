package com.widetns.pms;

import com.widetns.framework.aop.LoggingAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@SpringBootApplication
@ComponentScan("com.widetns")
@EnableAspectJAutoProxy
public class PmsApplication implements WebMvcConfigurer {

    private final LoggingAdvice loggingAdvice;

    @Autowired
    public PmsApplication(LoggingAdvice loggingAdvice) {
        this.loggingAdvice = loggingAdvice;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingAdvice).addPathPatterns("/**/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(PmsApplication.class, args);
    }

}
