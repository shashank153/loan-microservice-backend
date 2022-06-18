package com.rapipay.loanapi.loanapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rapipay.loanapi.loanapi.dao.ProductDAO;
import com.rapipay.loanapi.loanapi.entities.ProductEntity;
import com.rapipay.loanapi.loanapi.exceptions.ProductIdNotFoundException;

@Service
@CacheConfig(cacheNames = {"ProductEntity"})
public class ProductServiceImpl implements Services {
	@Autowired
	private ProductDAO productDAO;

	// Passing the whole productList to get request of view layer
	@Override
//	@Cacheable
	public List<ProductEntity> getProducts() {
		return this.productDAO.findAll();
	}

	// Passing the specific product from the productDTO list comparing that
	@Override
//	@Cacheable
	public ProductEntity getProduct(int productId) {
		System.out.println("Getting customer information for id:" + productId);
		ProductEntity productEntity = this.productDAO.findById(productId)
				.orElseThrow(() -> new ProductIdNotFoundException(productId));
		return productEntity;
	}

	// Posting the productDTO data
	@Override
	public ProductEntity addProduct(ProductEntity productEntity) {
		this.productDAO.save(productEntity);
		return productEntity;
	}

	// updating the product data
	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		int productId = productEntity.getProductId();
		this.productDAO.findById(productId).orElseThrow(() -> new ProductIdNotFoundException(productId));
		this.productDAO.save(productEntity);
		return productEntity;
	}

	// deleting product after getting if from DAO layer
	@Override
	public void deleteProduct(int productId) {
		ProductEntity productEntity = this.productDAO.findById(productId)
				.orElseThrow(() -> new ProductIdNotFoundException(productId));
		this.productDAO.delete(productEntity);
	}
}
