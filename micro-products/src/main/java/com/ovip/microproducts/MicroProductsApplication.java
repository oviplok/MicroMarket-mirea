package com.ovip.microproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroProductsApplication.class, args);
    }

}
