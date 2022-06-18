package com.rapipay.loanapi.loanapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//User defined exception
@ResponseStatus(HttpStatus.NOT_FOUND)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIdNotFoundException extends RuntimeException {
	private int productId;
	private static final long serialVersionUID = 1L;

	public String message() {
		return "Product not found with id : " + productId;
	}
}
