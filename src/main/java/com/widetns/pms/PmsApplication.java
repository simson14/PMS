package com.widetns.pms;

import com.widetns.framework.DefaultApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

@Slf4j
//@SpringBootApplication
public class PmsApplication extends DefaultApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsApplication.class, args);
    }

}
