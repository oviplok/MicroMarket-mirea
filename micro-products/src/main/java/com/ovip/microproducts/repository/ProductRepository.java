package com.ovip.microproducts.repository;

import com.ovip.microproducts.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
