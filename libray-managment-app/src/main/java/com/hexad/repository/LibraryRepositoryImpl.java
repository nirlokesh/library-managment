package com.hexad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hexad.entity.Book;
import com.hexad.entity.Library;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository{

	@Override
	public Library getLibrary() {
		return getAllBooks();
	}

	@Override
	public void borrowBook() {
		// TODO Auto-generated method stub
		
	}
	
	private static Library getAllBooks() {
		Library library = new Library();
		List<Book> bookList = new ArrayList<>();
		Book book = new Book();
		book.setName("Java head first");
		book.setId("BOOK001");
		book.setDescription("Devid T.");
		book.setCount(2);
		bookList.add(book);
		Book book2 = new Book();
		book2.setName("Spring head first");
		book2.setId("BOOK002");
		book2.setDescription("John T.");
		book2.setCount(4);
		bookList.add(book2);
		library.setBookList(bookList);
		return library;
	}

}
