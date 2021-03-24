package com.mvnrepo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mvnrepo.beans.MyArgumentsBean;

@Component
public class MyRunner implements ApplicationRunner {

	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		MyArgumentsBean getMyArguments=ctx.getBean(MyArgumentsBean.class,"myArgumentsBean");
		System.out.println(getMyArguments.getName());
		System.out.println("=============================");
		System.out.println("");
		System.out.println("Non-Optinal Arguments:"+args.getNonOptionArgs());
		System.out.println("Optinal Arguments:"+args.getOptionNames());
		for (String getArgsName:args.getOptionNames()) {
			System.out.println(getArgsName+":"+args.getOptionValues(getArgsName));
		}
		
	}

}
   