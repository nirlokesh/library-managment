package com.hexad.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import com.hexad.exception.LibraryException;
import com.hexad.repository.BorrowListRepository;
import com.hexad.repository.LibraryRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestLibraryService {
	
	private static final String USER_NAME = "hexad";

	@Mock
	private LibraryRepository libraryRepository;

	@Mock
	private BorrowListRepository borrowListRepository;
	
	@InjectMocks
	private LibraryServiceImpl libraryService;
	
	@Test(expected=LibraryException.class)
	public void testGetAllBooksWithNoBooks() {
		Mockito.when(this.libraryRepository.findAll()).thenReturn(Collections.emptyList());
		this.libraryService.loadLibrary(USER_NAME);
	}
	
	@Test
	public void testGetAllBooksWithBooks() {
		Mockito.when(this.libraryRepository.findAll()).thenReturn(Arrays.asList(new Book()));
		Library loadLibrary = this.libraryService.loadLibrary(USER_NAME);
		Assert.assertFalse("Library will contain book list", loadLibrary.getBookList().isEmpty());
		
	}
	
	@Test(expected=LibraryException.class)
	public void testBorrowBookNoBookAvailable() {
		Book book = new Book();
		book.setCount(0);
		Optional<Book> bookOp = Optional.of(book);
		Mockito.when(this.libraryRepository.findById(Mockito.anyInt())).thenReturn(bookOp);
		this.libraryService.borrowBook(USER_NAME, 1);
	}
	
	@Test(expected=LibraryException.class)
	public void testBorrowBookAlredyBorrowed() {
		Book book = new Book();
		book.setCount(3);
		Optional<Book> bookOp = Optional.of(book);
		Mockito.when(this.libraryRepository.findById(Mockito.anyInt())).thenReturn(bookOp);
		Mockito.when(this.borrowListRepository.findAll()).thenReturn(getBorrowList());
		this.libraryService.borrowBook(USER_NAME, 1);
	}
	
	@Test(expected=LibraryException.class)
	public void testBorrowBookOutOfLimitBorrow() {
		Book book = new Book();
		book.setCount(3);
		Optional<Book> bookOp = Optional.of(book);
		Mockito.when(this.libraryRepository.findById(Mockito.anyInt())).thenReturn(bookOp);
		Mockito.when(this.borrowListRepository.findAll()).thenReturn(getBorrowListWithOutOfLimitBook());
		this.libraryService.borrowBook(USER_NAME, 3);
	}
	
	@Test
	public void testBorrowBook() {
		Book book = new Book();
		book.setCount(3);
		Optional<Book> bookOp = Optional.of(book);
		Mockito.when(this.libraryRepository.findById(Mockito.anyInt())).thenReturn(bookOp);
		Mockito.when(this.borrowListRepository.findAll()).thenReturn(getBorrowList());
		Mockito.when(this.borrowListRepository.save(Mockito.any())).thenReturn(new BorrowList());
		Mockito.when(this.libraryRepository.findAll()).thenReturn(Arrays.asList(new Book()));
		Library borrowBook = this.libraryService.borrowBook(USER_NAME, 3);
		Assert.assertFalse("Borrow list will not be empty", borrowBook.getBorrowList().isEmpty());
	}
	
	@Test
	public void testSubmitBook(){
		Book book = new Book();
		book.setCount(3);
		Optional<Book> bookOp = Optional.of(book);
		Mockito.when(this.libraryRepository.findById(Mockito.anyInt())).thenReturn(bookOp);
		Mockito.when(this.libraryRepository.save(Mockito.any())).thenReturn(new Book());
		Mockito.when(this.libraryRepository.findAll()).thenReturn(Arrays.asList(new Book()));
		Library submitBook = this.libraryService.submitBook(USER_NAME, 2);
		Assert.assertFalse("Book will no longer be in borrow list", submitBook.getBorrowList().contains(new BorrowList(USER_NAME, 2)));
	}

	private List<BorrowList> getBorrowList() {
		return Arrays.asList(new BorrowList(USER_NAME, 1));
	}
	private List<BorrowList> getBorrowListWithOutOfLimitBook() {
		return Arrays.asList(new BorrowList(USER_NAME, 1),new BorrowList(USER_NAME, 2));
	}

}
