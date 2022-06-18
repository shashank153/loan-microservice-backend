package com.rapipay.loanapi.loanapi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private double principalAmount;
	@Column(nullable = false)
	private int tenure;
	@Column(nullable = false)
	private float rateOfInterest;
	@Column(nullable = false)
	private boolean loanStatus;
	@Column(nullable = false)
	private String createdBy;
	private Date createdOn = new Date();
	@Column(nullable = false)
	private String updatedBy;
	private Date updatedOn = new Date();
}
