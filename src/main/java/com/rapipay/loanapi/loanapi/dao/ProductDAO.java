package com.rapipay.loanapi.loanapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapipay.loanapi.loanapi.entities.ProductEntity;

public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {
}
