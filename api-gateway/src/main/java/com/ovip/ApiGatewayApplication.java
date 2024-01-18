package com.ovip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
//        ProcessBuilder pb = new ProcessBuilder("myCommand");
//        Map&lt;String, String&gt; env = pb.environment();
//        env.put("VAR1", "myValue");
        SpringApplication.run(ApiGatewayApplication.class, args);

    }
}
