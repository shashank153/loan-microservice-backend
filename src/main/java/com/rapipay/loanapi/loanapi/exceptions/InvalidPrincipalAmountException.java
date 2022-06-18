package com.rapipay.loanapi.loanapi.exceptions;

public class InvalidPrincipalAmountException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidPrincipalAmountException(double pricipalAmount) {
		super("Principle amount entered " + pricipalAmount + " is not valid!");
	}
}
