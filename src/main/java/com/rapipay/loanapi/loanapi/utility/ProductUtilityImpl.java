package com.rapipay.loanapi.loanapi.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.loanapi.loanapi.dao.ProductDAO;
import com.rapipay.loanapi.loanapi.entities.ProductEntity;

@Component
public class ProductUtilityImpl implements ProductUtility {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public double calculateEMI(int productId) {
		double emiAmount = 0;
		ProductEntity productEntitiy = this.productDAO.getById(productId);
		emiAmount = (double)(productEntitiy.getPrincipalAmount() * productEntitiy.getRateOfInterest()
				* (Math.pow((1 + productEntitiy.getRateOfInterest()), productEntitiy.getTenure())
						/ (Math.pow((1 + productEntitiy.getRateOfInterest()), productEntitiy.getTenure()) - 1)))/ 1200;
		System.out.println(emiAmount);
		return Math.round(emiAmount);
	}

}
