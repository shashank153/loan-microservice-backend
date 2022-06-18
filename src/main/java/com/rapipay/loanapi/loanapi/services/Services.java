package com.rapipay.loanapi.loanapi.services;

import java.util.List;

import com.rapipay.loanapi.loanapi.entities.ProductEntity;
import com.rapipay.loanapi.loanapi.exceptions.ProductIdNotFoundException;

public interface Services {

	// Method to get product list from dao
	public List<ProductEntity> getProducts();

	public ProductEntity getProduct(int productId) throws ProductIdNotFoundException;

	 ProductEntity addProduct(ProductEntity productEntity);

	public ProductEntity updateProduct(ProductEntity productEntity);

	public void deleteProduct(int parseInt);
}
