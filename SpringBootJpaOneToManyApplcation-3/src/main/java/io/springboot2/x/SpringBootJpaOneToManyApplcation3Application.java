package io.springboot2.x;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.springboot2.x.domain.Customer;
import io.springboot2.x.domain.Order;
import io.springboot2.x.repo.CustomerRepository;

@SpringBootApplication
public class SpringBootJpaOneToManyApplcation3Application implements ApplicationRunner {

	@Autowired
	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToManyApplcation3Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		CustomerRepository customerRepo=(CustomerRepository)ctx.getBean("customerRepository");
		
		
		
		//For add
		/*
		 * Customer customer=new Customer(101, "A", 9003002121L);
		 * 
		 * Order order1=new Order(91911, "TV", 5000.0); Order order2=new
		 * Order(91922,"LAPTOP", 25000.0); Order order3=new Order(91933, "BAG", 600.0);
		 * 
		 * Set<Order> orders=new HashSet<Order>(); orders.add(order1);
		 * orders.add(order2); orders.add(order3);
		 * 
		 * customer.setOrders(orders);
		 * 
		 * customerRepo.saveAndFlush(customer);
		 */
		 
		//For join query in repository
		/*
		 * List<Object[]> list=customerRepo.readCustomerWithOrder(); list.forEach(obj
		 * ->System.out.println(obj[0]+","+obj[1]+","+obj[2]+","+obj[3]));
		 */
		 
		  
		//For all
		/*
		 * List<Customer> listOfAllCustomers=customerRepo.findAll();
		 * 
		 * listOfAllCustomers.forEach(action->System.out.println(action));
		 */
		
		//For one customer
		/*
		 * Optional<Customer> opt = customerRepo.findById(101); Customer cust=opt.get();
		 */
			  
		customerRepo.deleteById(101);
			 
		
	}
	
	
	
	

}
