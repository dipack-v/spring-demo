package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.repository.ProductRepository;
import com.demo.service.domain.Product;

@Service
public class ProductService {

	ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id);
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void updateProduct(Product product, Long id) {
		productRepository.update(product, id);
	}
	
	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}
	

	

}
