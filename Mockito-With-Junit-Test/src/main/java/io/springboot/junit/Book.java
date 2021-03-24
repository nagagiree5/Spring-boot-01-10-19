package io.springboot.junit;

public class Book {
private Integer id;
private String bookName;
public Book(Integer id, String bookName) {
	super();
	this.id = id;
	this.bookName = bookName;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}



}
