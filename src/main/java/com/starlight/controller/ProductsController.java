package com.starlight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starlight.model.Product;

@Controller
public class ProductsController {

	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") long id) {
		Product product=new Product();
		product.setName("Cocacola");
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
