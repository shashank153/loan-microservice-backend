package com.rapipay.loanapi.loanapi.utility;

public interface ProductUtility {
	// Calculating EMI after fetching the product information from DAO
	public double calculateEMI(int productId);
}
