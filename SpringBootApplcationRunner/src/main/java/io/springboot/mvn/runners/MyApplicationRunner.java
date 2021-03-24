package io.springboot.mvn.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class MyApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("==============================================");
		System.out.println("From  ApplicationRunner...");
		System.out.println("NonOptionArgs-->>");
		args.getNonOptionArgs().forEach(System.out::println);
		System.out.println("OptionArgs-->>");
		args.getOptionNames().forEach(name -> {
			System.out.print(name);
			System.out.print(":");
			args.getOptionValues(name).forEach(System.out::println);
		});
		System.out.println("==============================================");
	}

}
