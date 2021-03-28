package com.hexad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexad.entity.Book;
import com.hexad.entity.BorrowList;
import com.hexad.entity.Library;
import com.hexad.exception.LibraryException;
import com.hexad.repository.BorrowListRepository;
import com.hexad.repository.LibraryRepository;

/**
 * The Class LibraryServiceImpl.
 */
@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryRepository libraryRepository;

	@Autowired
	private BorrowListRepository borrowListRepository;

	/* (non-Javadoc)
	 * @see com.hexad.service.LibraryService#loadLibrary(java.lang.String)
	 */
	@Override
	public Library loadLibrary(String userName) {
		List<Book> availableBooks = new ArrayList<>();
		this.libraryRepository.findAll().forEach(
				book -> availableBooks.add(book));
		if (availableBooks.isEmpty()) {
			throw new LibraryException("No books available in the library.");
		}
		Library library = new Library();
		library.setBorrowList(this.getBorrowList(userName));
		library.setBookList(availableBooks);
		return library;
	}

	
	/* (non-Javadoc)
	 * @see com.hexad.service.LibraryService#borrowBook(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Library borrowBook(String userName, Integer bookId) {
		if (this.libraryRepository.findById(bookId).get().getCount() == 0) {
			throw new LibraryException(
					"Cannont borrow this book, not in stock.");
		}
		List<BorrowList> userBorrowList = getBorrowList(userName);
		checkBorrowEligibility(bookId, userBorrowList);
		BorrowList borrowitem = new BorrowList(userName, bookId);
		Long id = this.borrowListRepository.count();
		borrowitem.setId(id.intValue());
		this.borrowListRepository.save(borrowitem);
		return updateLibrary(userName, bookId,Action.BORROW);
	}
	
	/* (non-Javadoc)
	 * @see com.hexad.service.LibraryService#submitBook(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Library submitBook(String userName, Integer bookId) {
		BorrowList borrowitem = null;
		List<BorrowList> userBorrowList = getBorrowList(userName);
		if(!userBorrowList.isEmpty()){
			borrowitem = userBorrowList.stream().filter(item->item.getBookId().equals(bookId)).collect(Collectors.toList()).get(0);
			this.borrowListRepository.delete(borrowitem);
		}
		return updateLibrary(userName, bookId,Action.SUBMIT);
	}

	private Library updateLibrary(String userName, Integer bookId,Action action) {
		Book book = this.libraryRepository.findById(bookId).get();
		Integer count = Integer.sum(book.getCount(), action.getValue());
		if(book.getCount()>=0) book.setCount(count);
		this.libraryRepository.save(book);
		return this.loadLibrary(userName);
	}

	private List<BorrowList> getBorrowList(String userName) {
		List<BorrowList> userBorrowList = new ArrayList<>();
		this.borrowListRepository.findAll().forEach(borrowEntry -> {
			if (borrowEntry.getUserName().equals(userName)) {
				userBorrowList.add(borrowEntry);
			}
		});
		return userBorrowList;
	}

	private void checkBorrowEligibility(Integer bookId,
			List<BorrowList> userBorrowList) {
		if (!userBorrowList.isEmpty()) {
			if (userBorrowList.size() > 1) {
				throw new LibraryException(
						"Cannont borrow this book, one user can only borrow 2 books.");
			}
			if (userBorrowList.stream().anyMatch(
					item -> item.getBookId().equals(bookId))) {
				throw new LibraryException(
						"Cannont borrow this book, one user can only borrow 1 copy of any book.");
			}
		}
	}

}
