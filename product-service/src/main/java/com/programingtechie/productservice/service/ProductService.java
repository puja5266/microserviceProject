package com.programingtechie.productservice.service;

import com.programingtechie.productservice.dto.ProductResponse;
import com.programingtechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.programingtechie.productservice.dto.ProductRequest;
import com.programingtechie.productservice.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		 Product product = Product.builder()
				 .name(productRequest.getName())
				 .description(productRequest.getDescription())
				 .price(productRequest.getPrice())
				 .build();

		 productRepository.save(product);
		 log.info("Product {} is saved", product.getId() );
	}

	public List<ProductResponse> getAllProduct() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapTOProduct).toList();
	}

	private ProductResponse mapTOProduct(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
}
