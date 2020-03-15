package com.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.service.domain.Product;

@Repository
public class ProductRepository {

	List<Product> store = new ArrayList<>();
	
	public ProductRepository() {
		store.add(new Product(1L, "Coca-cola", BigDecimal.valueOf(2.36)));
		store.add(new Product(2L, "Bread", BigDecimal.valueOf(1.7)));
	}

	public Product save(Product product) {
		product.setId(Long.valueOf(count()));
		store.add(product);
		return product;
	}

	public void update(Product product, Long id) {
		for (int i = 0; i < store.size(); i++) {
			Product e = store.get(i);
			if (e.getId().equals(id)) {
				store.set(i, product);
				break;
			}
		}
	}

	public Product findById(Long id) {
		return store.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}

	public List<Product> findAll() {
		return store;
	}

	public int count() {
		return store.size();
	}

	public void delete(Long id) {
		store.removeIf(e -> e.getId().equals(id));
	}

}
