package io.springboot2.x;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.springboot2.x.entity.Customer;
import io.springboot2.x.entity.Order;
import io.springboot2.x.repository.CustomerRepository;
import io.springboot2.x.repository.OrderRepository;

@SpringBootApplication
public class SpringbootJpaManyToOneBidirApplication8Application implements CommandLineRunner {
	
	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaManyToOneBidirApplication8Application.class, args);
	}
	@Override	
	public void run(String... args) throws Exception{
		
	CustomerRepository custRepo = (CustomerRepository)ctx.getBean("customerRepository");
		
		
		  OrderRepository ordRepo = (OrderRepository)ctx.getBean("orderRepository");
		  
			
			/*
			 * Customer customer = new Customer(102,"ANIL",9492949091L);
			 * 
			 * Order order1 = new Order(8001,"Bangles", 200.00); Order order2 = new
			 * Order(8002,"cosmetics", 4000.00); Order order3 = new Order(8003,
			 * "Pendrive",1200.00);
			 * 
			 * Set<Order> orders = new HashSet<Order>(); orders.add(order1);
			 * orders.add(order2); orders.add(order3);
			 * 
			 * customer.setOrders(orders);
			 * 
			 * custRepo.save(customer);
			 */
			 
		 		
		  
		  List<Object[]> list=ordRepo.readCustomerWithOrder();
		  list.forEach(obj ->System.out.println(obj[0]+","+obj[1]+","+obj[2]+","+obj[3]));
		  
		  
		
		/*
		 * Optional<Customer> opt = custRepo.findById(101); Customer cust = opt.get();
		 * System.out.println(cust);
		 * 
		 * Optional<Order> opt1 = ordRepo.findById(9002); Order ord = opt1.get();
		 * System.out.println(ord);
		 */		 
		  //ordRepo.deleteById(8001);
		
		/*
		 * custRepo.deleteById(102);
		 * System.out.println("Customer deleted successfully");
		 */		 	}

}












