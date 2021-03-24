package io.springboot2.x.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
