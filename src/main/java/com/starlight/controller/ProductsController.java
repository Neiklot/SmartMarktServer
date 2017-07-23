package com.starlight.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starlight.model.Product;
import com.starlight.services.ProductService;

@CrossOrigin(origins = "http://localhost:8100")
@Controller
public class ProductsController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/{idProduct}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("idProduct") long idProduct) {
		Product product = productService.getProducts(idProduct);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<?> getProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		Long idProduct = productService.createProduct(product);
		return new ResponseEntity(idProduct, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> modifyProduct(@RequestBody Product product) {
		Long idProduct = productService.modifyProduct(product);
		return new ResponseEntity(idProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{idProduct}/getImage", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@PathVariable("idProduct") long idProduct, HttpServletRequest request) throws IOException {
		String rpath = request.getRealPath("/resources/images/");
		Product product = productService.getProducts(idProduct);
		String image = product.getImage();
		if (image == null || image.equalsIgnoreCase("null")) {
			image = "nuevoProducto.jpg";
		}
		rpath = rpath + "/" + image; // whatever path you used for storing the file
		Path path = Paths.get(rpath);
		byte[] data = Files.readAllBytes(path);
		return data;
	}

	@RequestMapping(value = "/product/{idProduct}/getIcon", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getIcon(@PathVariable("idProduct") long idProduct, HttpServletRequest request) throws IOException {
		Path path = null;
		String rpath = request.getRealPath("/resources/icons/");
		Product product = productService.getProducts(idProduct);
		if (product.getIcon() != null) {
			rpath = rpath + "/" + product.getIcon(); // whatever path you used for storing the file
			path = Paths.get(rpath);
		} else {
			rpath = rpath + "/noCategory.png"; // whatever path you used for storing the file
			path = Paths.get(rpath);
		}
		return Files.readAllBytes(path);
	}
}
