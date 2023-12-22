package com.ovip;

import com.ovip.microorder.MicroOrderApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest(classes = MicroOrderApplication.class)
@Testcontainers
@AutoConfigureMockMvc
class MicroOrderApplicationTests {

    @Test
    void contextLoads() {
    }

    MicroOrderApplicationTests() {
    }
}
