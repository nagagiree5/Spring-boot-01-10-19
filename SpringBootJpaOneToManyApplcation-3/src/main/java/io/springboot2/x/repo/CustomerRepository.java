package io.springboot2.x.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
@Query("select c.customerId, c.customerName, o.itemName, o.price from Customer c join c.orders o")
List<Object[]> readCustomerWithOrder();



}
