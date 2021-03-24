package com.hexad.repository;

import com.hexad.entity.Library;

public interface LibraryRepository {
	
	/**
	 * Gets all available books with the details.
	 * @return
	 */

	Library getLibrary();
	
	/**
	 * Updates the library when the book is borrowed.
	 * @return
	 */
	void borrowBook();

}
