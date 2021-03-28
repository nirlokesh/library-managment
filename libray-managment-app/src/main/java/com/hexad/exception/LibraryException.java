package com.hexad.exception;

public class LibraryException extends RuntimeException{
	private String message;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LibraryException(String message){
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
