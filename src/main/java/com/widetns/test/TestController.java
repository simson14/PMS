package com.widetns.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class TestController {

    private final TestService service;

    @Autowired
    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test(@RequestParam Map<String, String> param) {
        log.info("aaaa");
        service.testService(param);
        return "Hello World";
    }

    @GetMapping("/test1")
    public String test1(@RequestParam String arg, @RequestParam String arg1) {
        log.info("bbb");
//        service.testService();
        return "Hello World";
    }
}
