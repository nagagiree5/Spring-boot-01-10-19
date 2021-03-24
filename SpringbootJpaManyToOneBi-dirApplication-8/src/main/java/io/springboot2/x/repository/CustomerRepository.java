package io.springboot2.x.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springboot2.x.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c.customerId, c.customerName, o.itemName, o.price from Order o left outer join o.customer c")
	List<Object[]> readCustomerWithOrder();

}
