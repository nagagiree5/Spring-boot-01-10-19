package io.springboot2.x.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
