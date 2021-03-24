package io.springboot.junit.service;

import java.util.List;

import io.springboot.junit.Book;

public interface ILibraryBookService {

	public List<Book> findAllBooks();
}
