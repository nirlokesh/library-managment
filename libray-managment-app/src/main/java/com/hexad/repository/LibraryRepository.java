package com.hexad.repository;

import org.springframework.data.repository.CrudRepository;

import com.hexad.entity.Book;
public interface LibraryRepository extends CrudRepository<Book, Integer>  
{  
}
