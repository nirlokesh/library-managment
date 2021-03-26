package com.hexad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexad.entity.Book;
import com.hexad.entity.Library;
import com.hexad.repository.LibraryRepository;


@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	public Library getAllBooks(){
		List<Book> availableBooks = new ArrayList<>();
		this.libraryRepository.findAll().forEach(book->availableBooks.add(book));
		Library library= new Library();
		library.setBookList(availableBooks);
		return library;
	}

}
