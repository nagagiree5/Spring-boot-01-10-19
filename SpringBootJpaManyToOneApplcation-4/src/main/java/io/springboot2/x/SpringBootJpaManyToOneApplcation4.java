package io.springboot2.x;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.springboot2.x.domain.Customer;
import io.springboot2.x.domain.Order;
import io.springboot2.x.repository.CustomerRepository;
import io.springboot2.x.repository.OrderRepository;

@SpringBootApplication
public class SpringBootJpaManyToOneApplcation4 implements CommandLineRunner {
	
	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaManyToOneApplcation4.class, args);
	}
	@Override	
	public void run(String... args) throws Exception{
		
		
		  OrderRepository ordRepo = (OrderRepository)ctx.getBean("orderRepository");
		  
		
		
		/*
		 * Customer customer = new Customer(104,"Giridhar",9492011956L);
		 * 
		 * Order order1 = new Order(6001,"Mobile", 12000.00); Order order2 = new
		 * Order(6002,"Laptop", 51099.00); Order order3 = new Order(6003,
		 * "HardDisk",3200.00);
		 * 
		 * order1.setCustomer(customer); order2.setCustomer(customer);
		 * order3.setCustomer(customer);
		 * 
		 * ordRepo.save(order1); ordRepo.save(order2); ordRepo.save(order3);
		 */
		 
		 		  
		 ordRepo.deleteById(6001);
		
		  
		/*
		 * Optional<Customer> opt = custRepo.findById(101); Customer cust = opt.get();
		 * System.out.println(cust);
		 * 
		 * Optional<Order> opt1 = ordRepo.findById(9002); Order ord = opt1.get();
		 * System.out.println(ord);
		 */		 
		
		
		 		 	}

}












