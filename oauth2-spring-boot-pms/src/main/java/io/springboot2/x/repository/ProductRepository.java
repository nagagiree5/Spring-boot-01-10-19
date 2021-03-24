package io.springboot2.x.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
