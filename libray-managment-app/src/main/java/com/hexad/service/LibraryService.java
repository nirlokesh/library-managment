package com.hexad.service;

import com.hexad.entity.Library;

public interface LibraryService {

	/**
	 * Load library.
	 *
	 * @param userName the user name
	 * @return the library
	 */
	Library loadLibrary(String userName);
	
	/**
	 * Borrow book.
	 *
	 * @param userName the user name
	 * @param bookId the book id
	 * @return the library
	 */
	Library borrowBook(String userName, Integer bookId);
	
	/**
	 * Submit book.
	 *
	 * @param userName the user name
	 * @param bookId the book id
	 * @return the library
	 */
	Library submitBook(String userName, Integer bookId);
	
}
