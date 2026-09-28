package com.accenture.ltt;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.accenture.ltt.dao.EmployeeDAO;

@SpringBootApplication
public class Application {
	//Builder API
	public static void main(String[] args) {
		//How to get access to the ApplicationContext in spring Boot
		SpringApplicationBuilder app = new SpringApplicationBuilder()
				.sources(Application.class)
				.bannerMode(Banner.Mode.OFF);

		// returns an instance of ConfigurableApplicationContext that can be used to
		// perform normal Spring operations.
		ConfigurableApplicationContext ctx = app.run(args);

		EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		System.out.println(employeeDAO.getAllEmployee());

		ctx.close();

	}
}