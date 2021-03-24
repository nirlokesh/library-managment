package com.hexad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexad.entity.Library;
import com.hexad.repository.LibraryRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LibraryManagmentController {

	@Autowired
	private LibraryRepository libraryRepository;

	@GetMapping("/library")
	public Library getLibrary() {
		return this.libraryRepository.getLibrary();
	}
	


}