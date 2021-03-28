package com.hexad.response;

import com.hexad.entity.Library;
import com.hexad.exception.ErrorTo;

public class LibraryResponse {

	private Library library;
	
	private ErrorTo errorTo;
	
	public LibraryResponse(){}
	
	public LibraryResponse(Library library){
		this.library = library;
	}
	
	public ErrorTo getErrorTo() {
		return errorTo;
	}
	public void setErrorTo(ErrorTo errorTo) {
		this.errorTo = errorTo;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	

	
}
