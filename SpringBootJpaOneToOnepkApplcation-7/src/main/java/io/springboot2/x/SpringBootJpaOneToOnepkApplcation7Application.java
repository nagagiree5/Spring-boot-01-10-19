package io.springboot2.x;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.springboot2.x.domain.Passport;
import io.springboot2.x.domain.Person;
import io.springboot2.x.repo.PassportRepository;

@SpringBootApplication
public class SpringBootJpaOneToOnepkApplcation7Application implements ApplicationRunner{

	@Autowired
	private ApplicationContext ctx;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToOnepkApplcation7Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
PassportRepository passportRepository=(PassportRepository)ctx.getBean("passportRepository");
		
		Person person1=new Person();
		person1.setPersonid(105592);
		person1.setPersonname("Giridhar");
		
		Passport passport1 =new Passport();
		//passport1.setPassportid(120113);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date expiredate=sdf.parse("31-12-2025");
		
		passport1.setExpiredate(expiredate);
		
		passport1.setPerson(person1);
		
		passportRepository.save(passport1);
		
	}

}
