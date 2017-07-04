package com.starlight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starlight.model.Product;
import com.starlight.services.ProductService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductService productService;

	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") long id) {
		Product product=productService.getProducts(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<?> getProducts() {
		List<Product> products=productService.getAllProducts();
		return new ResponseEntity(products, HttpStatus.OK);
	}
}
