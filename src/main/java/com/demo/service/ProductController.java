package com.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.domain.Product;

@RestController
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}

	@PostMapping(value = "/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

	@PutMapping("/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable Long id) {
		productService.updateProduct(product, id);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
