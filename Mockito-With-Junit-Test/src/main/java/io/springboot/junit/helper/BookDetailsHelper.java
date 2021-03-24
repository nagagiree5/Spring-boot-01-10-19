package io.springboot.junit.helper;

import java.util.ArrayList;
import java.util.List;

import io.springboot.junit.Book;

public class BookDetailsHelper {

	public static List<Book> getBooks(){
		List<Book> bookList=new ArrayList<Book>();
		bookList.add(new Book(111,"JavaSE"));
		bookList.add(new Book(222,"SpringBoot2.x"));
		bookList.add(new Book(333,"Microservices"));
	
		return bookList;
		
	}
}
