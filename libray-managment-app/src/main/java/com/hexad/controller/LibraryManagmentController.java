package com.hexad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexad.entity.Library;
import com.hexad.service.LibraryService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LibraryManagmentController {

	@Autowired
	private LibraryService libraryService;

	@GetMapping("/library")
	public Library getLibrary() {
		return this.libraryService.getAllBooks();
	}
	


}