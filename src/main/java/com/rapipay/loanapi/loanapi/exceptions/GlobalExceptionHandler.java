package com.rapipay.loanapi.loanapi.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	// Handle specific exceptions
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<?> HandleProductIdNotFoundException(ProductIdNotFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.message(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
//	//Handling invalid principal amount exception
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@ExceptionHandler(ProductIdNotFoundException.class)
//	public ResponseEntity<?> HandleInvalidPrincipleAmountException(InvalidPrincipalAmountException exception,
//			WebRequest request) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> HandleAPIException(APIException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.BAD_GATEWAY);
	}

	// Handle global exception
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HadleGlobalException(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
