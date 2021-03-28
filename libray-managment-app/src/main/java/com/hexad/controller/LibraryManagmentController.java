package com.hexad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexad.response.LibraryResponse;
import com.hexad.service.LibraryServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LibraryManagmentController {

	@Autowired
	private LibraryServiceImpl libraryService;

	@GetMapping("/library/{userName}")
	public LibraryResponse getLibrary(@PathVariable("userName") String userName) {
		return new LibraryResponse(this.libraryService.loadLibrary(userName));
	}

	@PostMapping("/borrow/{userName}/{bookId}")
	public LibraryResponse borrowBook(
			@PathVariable("userName") String userName,
			@PathVariable("bookId") Integer bookId) {
		return new LibraryResponse(this.libraryService.borrowBook(userName,
				bookId));
	}

	@PostMapping("/submit/{userName}/{bookId}")
	public LibraryResponse submitBook(
			@PathVariable("userName") String userName,
			@PathVariable("bookId") Integer bookId) {
		return new LibraryResponse(this.libraryService.submitBook(userName,
				bookId));
	}

}