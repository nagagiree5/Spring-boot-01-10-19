package io.springboot2.x.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	private Integer authorid;
	@Column(length = 25)
	private String authorname;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "authors")
	private Set<Book> books;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(Integer authorid, String authorname) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
	}

	public Integer getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorname=" + authorname + "]";
	}

}
