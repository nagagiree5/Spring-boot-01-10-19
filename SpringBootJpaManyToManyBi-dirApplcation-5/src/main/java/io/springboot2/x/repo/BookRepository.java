package io.springboot2.x.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot2.x.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
