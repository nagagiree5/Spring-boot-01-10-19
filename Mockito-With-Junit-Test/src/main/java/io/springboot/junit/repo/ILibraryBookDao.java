package io.springboot.junit.repo;

import java.util.List;

import io.springboot.junit.Book;

public interface ILibraryBookDao {
	public List<Book> getAllBooks();

}
