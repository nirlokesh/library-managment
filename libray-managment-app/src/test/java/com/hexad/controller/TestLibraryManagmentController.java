package com.hexad.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hexad.entity.Book;
import com.hexad.entity.Library;
import com.hexad.service.LibraryService;


@RunWith(MockitoJUnitRunner.class)
public class TestLibraryManagmentController {

	@InjectMocks
	private LibraryManagmentController libraryManagmentController;
	
	@Mock
	private LibraryService libraryService;

	@Test
	public void testGetLibraryWithEmptyLibrary() {
		Mockito.when(this.libraryService.getAllBooks()).thenReturn(null);
		Library library = this.libraryManagmentController.getLibrary();
		Assert.assertNull("The library object will be null when there is no books available in the library.", library);
	}
	
	@Test
	public void testGetLibraryWithBooks() {
		Mockito.when(this.libraryService.getAllBooks()).thenReturn(getLibrary());
		Library library = this.libraryManagmentController.getLibrary();
		Assert.assertEquals("Library is having two books", 2, library.getBookList().size());
	}
	
	private static Library getLibrary() {
		Library library = new Library();
		List<Book> bookList = new ArrayList<>();
		Book book = new Book();
		book.setName("Java head first");
		book.setId(1);
		book.setDescription("Devid T.");
		book.setCount(2);
		bookList.add(book);
		Book book2 = new Book();
		book2.setName("Spring head first");
		book2.setId(2);
		book2.setDescription("John T.");
		book2.setCount(4);
		bookList.add(book2);
		library.setBookList(bookList);
		return library;
	}

}