package com.ovip.microproducts;

import com.ovip.microproducts.dto.ProductRequest;
import com.ovip.microproducts.model.Product;
import com.ovip.microproducts.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroProductsApplication.class, args);}

        @Bean
        public CommandLineRunner loadData(ProductRepository productRepository){
            return args -> {
                Product product = new Product();
                product.setName("Голод и Вкуснятина");
                product.setDescription("ОЙ ой");
                product.setPrice(480.00);
//                product.setSkuCode("Chebupizza");
//                product.setQuantity(100);

                Product product1 = new Product();
                product1.setName("Chebupeli");
                product1.setPrice(169.99);

                productRepository.save(product);
                productRepository.save(product1);
            };
        }

}
