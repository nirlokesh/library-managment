package com.hexad.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hexad.entity.Book;
import com.hexad.entity.BorrowList;
import com.hexad.entity.Library;
import com.hexad.response.LibraryResponse;
import com.hexad.service.LibraryServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class TestLibraryManagmentController {

	@InjectMocks
	private LibraryManagmentController libraryManagmentController;
	
	@Mock
	private LibraryServiceImpl libraryService;

	@Test
	public void testGetLibraryWithEmptyLibrary()  {
		Mockito.when(this.libraryService.loadLibrary("hexad")).thenReturn(null);
		LibraryResponse library = this.libraryManagmentController.getLibrary("hexad");
		Assert.assertNull("The library object will be null when there is no books available in the library.", library.getLibrary());
	}
	
	@Test
	public void testGetLibraryWithBooks()  {
		Mockito.when(this.libraryService.loadLibrary("hexad")).thenReturn(getLibrary());
		LibraryResponse library = this.libraryManagmentController.getLibrary("hexad");
		Assert.assertEquals("Library is having two books", 2, library.getLibrary().getBookList().size());
	}
	
	@Test
	public void testSubmitBook(){
		 List<BorrowList> borrowList = new ArrayList<>();
		 borrowList.add(new BorrowList("hexad", 2));
			Library library = new Library();
		 library.setBorrowList(new ArrayList<BorrowList>());
		 Mockito.when(this.libraryService.submitBook(Mockito.anyString(), Mockito.anyInt())).thenReturn(library);
		 LibraryResponse libraryResponse = this.libraryManagmentController.submitBook("hexad", 2);
		 Assert.assertNotEquals("Borrow list will get reduced with one entry",borrowList.size(), libraryResponse.getLibrary().getBorrowList().size());
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