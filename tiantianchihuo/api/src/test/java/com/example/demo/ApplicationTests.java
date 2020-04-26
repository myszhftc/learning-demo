package com.example.demo;

import com.example.service.StuService;
import com.example.service.TestTransService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private TestTransService testTransService;

    @Test
    void contextLoads() {
        testTransService.testPropagationTrans();
    }

}
