package com.widetns.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public void testService(Map<String, String> param) {
        log.info("testService");
        List<Map> result = testMapper.selectTest();

        log.error("error");
    }

    public void testService1() {
        log.info("testService");
        List<Map> result = testMapper.selectTest();

        log.error("error");
    }


}

