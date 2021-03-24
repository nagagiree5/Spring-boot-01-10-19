package io.springboot2.x.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Integer> {

}
