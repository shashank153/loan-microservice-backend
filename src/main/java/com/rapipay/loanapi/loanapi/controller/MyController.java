package com.rapipay.loanapi.loanapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rapipay.loanapi.loanapi.entities.ProductEntity;
import com.rapipay.loanapi.loanapi.exceptions.ProductIdNotFoundException;
import com.rapipay.loanapi.loanapi.services.Services;
import com.rapipay.loanapi.loanapi.utility.ProductUtility;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MyController {
	@Autowired
	private Services productService;
	@Autowired
	private ProductUtility productUtility;

	// GET the product list
	@GetMapping("/products")
	public List<ProductEntity> getProducts() {
		return productService.getProducts();
	}

	// GET the single product
	@GetMapping("/products/{productId}")
	public ProductEntity getProduct(@PathVariable String productId) throws ProductIdNotFoundException {
		return this.productService.getProduct(Integer.parseInt(productId));
	}

	// POST single product data
	@PostMapping("/products")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		return this.productService.addProduct(productEntity);
	}

	// Update the existing product
	@PutMapping("/products")
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) {
		return this.productService.updateProduct(productEntity);
	}

	// Delete the existing product
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		this.productService.deleteProduct(productId);
	}

	// Calculate emi
	@GetMapping("/products/calculate-emi/{productId}")
	public double calculateEmi(@PathVariable int productId) {
		return productUtility.calculateEMI(productId);
	}
}
