package com.hexad.entity;

import java.util.List;

public class Library {
	private List<Book> bookList;
	private List<BorrowList> borrowList;
	
	public List<BorrowList> getBorrowList() {
		return borrowList;
	}

	public void setBorrowList(List<BorrowList> borrowList) {
		this.borrowList = borrowList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}
