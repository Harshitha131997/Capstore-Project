package com.capgemini.capstore.exceptions;

public class ProductDetailsNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductDetailsNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
