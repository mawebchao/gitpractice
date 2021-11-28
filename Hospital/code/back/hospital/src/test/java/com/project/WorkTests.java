package com.project;

import com.project.provider.WorkSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkTests {
    @Autowired
    WorkSender workSender;

    @Test
    void test1() throws Exception {
        workSender.send();
    }
}