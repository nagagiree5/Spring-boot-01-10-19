package io.springboot.junit.service;

import java.util.List;

import io.springboot.junit.Book;
import io.springboot.junit.repo.ILibraryBookDao;

public class LibraryBookService implements ILibraryBookService {
	
	private ILibraryBookDao dao;
	
	public void setDao(ILibraryBookDao dao) {
		this.dao = dao;
	}


	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

}
