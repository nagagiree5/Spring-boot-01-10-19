package io.springboot2.x.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
