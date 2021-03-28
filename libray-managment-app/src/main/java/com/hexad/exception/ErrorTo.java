package com.hexad.exception;

import org.springframework.http.HttpStatus;

public class ErrorTo{
	private String errorMessage;
	private HttpStatus status;
	ErrorTo(String errorMessage, HttpStatus status){
		this.errorMessage = errorMessage;
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	
}