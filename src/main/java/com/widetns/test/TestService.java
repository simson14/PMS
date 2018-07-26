package com.widetns.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class TestService {

    public void testService(Map<String, String> param) {
        log.info("testService");
    }
}

