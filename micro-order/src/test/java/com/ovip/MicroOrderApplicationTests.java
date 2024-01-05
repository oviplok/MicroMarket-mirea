package com.ovip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ovip.microorder.MicroOrderApplication;
import com.ovip.microorder.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest(classes = MicroOrderApplication.class)
@Testcontainers
@AutoConfigureMockMvc
class MicroOrderApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Test
//    void shouldCreateProduct() throws Exception {
//    }

    MicroOrderApplicationTests() {
    }
}
