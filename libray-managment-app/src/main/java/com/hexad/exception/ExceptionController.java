package com.hexad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hexad.response.LibraryResponse;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = LibraryException.class)
	public ResponseEntity<Object> libraryException(LibraryException exception) {
		LibraryResponse libraryResponse = new LibraryResponse();
		libraryResponse.setErrorTo(new ErrorTo(exception.getMessage(),
				HttpStatus.CONFLICT));
		return new ResponseEntity<Object>(libraryResponse,libraryResponse.getErrorTo().getStatus());
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(LibraryException exception) {
		LibraryResponse libraryResponse = new LibraryResponse();
		libraryResponse.setErrorTo(new ErrorTo("Opps!! something went wrong. Please try again later.",
				HttpStatus.INTERNAL_SERVER_ERROR));
		return new ResponseEntity<Object>(libraryResponse,libraryResponse.getErrorTo().getStatus());
	}
}
