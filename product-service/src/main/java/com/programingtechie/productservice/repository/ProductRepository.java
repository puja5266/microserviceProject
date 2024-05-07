package com.programingtechie.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programingtechie.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
