package com.accenture.ltt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Base64Utils;

import com.accenture.ltt.client.MyFeignClient;
import com.accenture.ltt.model.Employee;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumer {

	@Autowired
	private MyFeignClient feignClient;

	private String getAuthorizationHeaders() {
		String username = "db_user";
		String password = "db_user";
		byte[] encodedBytes = Base64Utils.encode((username + ":" + password).getBytes());
		String authHeader = "Basic " + new String(encodedBytes);
		return authHeader;
	}

	public void listAllEmployee() {
		System.out.println("Testing listAllUsers API-----------");
		System.out.println(feignClient.findAll(getAuthorizationHeaders()).getBody());
	}

	public void getEmployee() {
		System.out.println("Testing getEmployee----------");
		System.out.println(feignClient.findByEmployeeId(getAuthorizationHeaders(),1001).getBody());
	}

	public void createEmployee() {
		System.out.println("Testing create User API----------");
		Employee emp = new Employee("TestMSD", 0, 1000.0, 103);
		System.out.println(feignClient.addEmployee(getAuthorizationHeaders(),emp).getBody());
	}

	public void updateEmployee() {
		System.out.println("Testing update User API----------");
		Employee emp = new Employee("UpdateMSD", 1003, 1000.0, 103);
		System.out.println(feignClient.updateEmployee(getAuthorizationHeaders(),emp).getBody());
	}

	public void deleteEmployee() {
		System.out.println("Testing delete User API----------");
		System.out.println(feignClient.deleteEmployee(getAuthorizationHeaders(),1004).getBody());
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(FeignConsumer.class, args);
		FeignConsumer consumer1 = applicationContext.getBean(FeignConsumer.class, "feignConsumer1");
		try {
			//consumer1.listAllEmployee();
			consumer1.getEmployee();
			//consumer1.createEmployee();
			//consumer1.updateEmployee();
			//consumer1.deleteEmployee();
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		applicationContext.close();

	}
}