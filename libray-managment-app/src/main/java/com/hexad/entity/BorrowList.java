package com.hexad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BorrowList")
public class BorrowList {

	@Id
	@Column
	private Integer id;
	
	@Column
	private String userName;
	
	@Column
	private Integer bookId;
	
	public BorrowList(String userName,Integer bookId){
		this.userName = userName;
		this.bookId = bookId;
	}

	public BorrowList() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	
}
