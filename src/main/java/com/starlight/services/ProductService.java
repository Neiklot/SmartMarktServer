package com.starlight.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.starlight.model.Product;

@Service
public class ProductService {

	@PersistenceContext
	private EntityManager em;

	public Product getProducts(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	public List<Product> getAllProducts() {
		Query q = em.createNativeQuery("Select * from Product", Product.class);
		List<Product> products = q.getResultList();
		return products;
	}

	@Transactional
	public Long createProduct(Product product) {
		em.persist(product);
		return product.getId();
	}
}
