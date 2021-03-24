package io.springboot2.x;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.springboot2.x.domain.Author;
import io.springboot2.x.domain.Book;
import io.springboot2.x.repo.AuthorRepository;
import io.springboot2.x.repo.BookRepository;

@SpringBootApplication
public class SpringBootJpaManyToManyBiDirApplcation5Application implements ApplicationRunner {

	@Autowired
	private ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaManyToManyBiDirApplcation5Application.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		BookRepository bookRepository = (BookRepository) ctx.getBean("bookRepository");
		AuthorRepository authorRepository = (AuthorRepository) ctx.getBean("authorRepository");
		/*
		 * Book book1=new Book(1, "Springboot2.x"); Book book2=new Book(2, "Oracle");
		 * Book book3=new Book(3, "Java");
		 * 
		 * 
		 * Author author1=new Author(101, "A"); Author author2=new Author(102, "B");
		 * Author author3=new Author(103, "C");
		 * 
		 * Set<Author> authorSet1=new HashSet<Author>(); authorSet1.add(author1);
		 * authorSet1.add(author2);
		 * 
		 * Set<Author> authorSet2=new HashSet<Author>(); authorSet2.add(author1);
		 * authorSet2.add(author2); authorSet2.add(author3);
		 * 
		 * Set<Author> authorSet3=new HashSet<Author>(); authorSet3.add(author2);
		 * authorSet3.add(author3);
		 * 
		 * 
		 * book1.setAuthors(authorSet1); book2.setAuthors(authorSet2);
		 * book3.setAuthors(authorSet3);
		 * 
		 * bookRepository.saveAndFlush(book1); bookRepository.saveAndFlush(book2);
		 * bookRepository.saveAndFlush(book3);
		 */

		// Remove author with id 103 from book with id 2

		/*
		 * Optional<Book> opt=bookRepository.findById(2); Book book=opt.get();
		 * Set<Author> authors=book.getAuthors(); //
		 * authors.forEach(auth->System.out.println(auth));
		 * 
		 * Optional<Author> opt2=authorRepository.findById(103); Author
		 * author=opt2.get();
		 * 
		 * 
		 * for (Author a : authors) { if(a.getAuthorid()==author.getAuthorid()) {
		 * authors.remove(a); } }
		 * 
		 * 
		 * authors.remove(author); authors.forEach(auth->System.out.println(auth));
		 * 
		 * book.setAuthors(authors);
		 */

		// Add a new author to book with id 1
		Author new_author = new Author(105, "E");
		Optional<Book> opt3 = bookRepository.findById(1);
		Book book = opt3.get();
		Set<Author> authors=book.getAuthors();
		
		authors.add(new_author);
		
	}

}
