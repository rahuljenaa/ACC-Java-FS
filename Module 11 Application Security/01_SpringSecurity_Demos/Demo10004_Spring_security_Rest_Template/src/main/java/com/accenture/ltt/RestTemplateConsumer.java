package com.accenture.ltt;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.accenture.ltt.error.handler.MyErrorHandle;
import com.accenture.ltt.model.Employee;

@SpringBootApplication
public class RestTemplateConsumer {

	public static final String REST_SERVICE_URI = "http://localhost:8095/emp/controller/";

	
	private static HttpHeaders getHeaders() {
		String username = "db_dba";
		String password = "db_dba";
		byte[] encodedBytes = Base64Utils.encode((username + ":" + password).getBytes());
		String authHeader = "Basic " + new String(encodedBytes);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authHeader);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		return headers;
	}

	public static HttpEntity<String> getSecurityEntity() {
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		return request;
	}

	/* GET */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void listAllEmployee() {
		System.out.println("Testing listAllUsers API-----------");
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandle());
		ResponseEntity<List> res = restTemplate.exchange(REST_SERVICE_URI + "getDetails?", HttpMethod.GET,getSecurityEntity(), List.class);
		List<LinkedHashMap<String, Object>> employeeMMap = res.getBody();
		if (employeeMMap != null) {
			for (LinkedHashMap<String, Object> map : employeeMMap) {
				System.out.println("Employee : id=" + map.get("employeeId") + ", Name=" + map.get("employeeName")
						+ ", Salary=" + map.get("salary") + ", DepartmentCode=" + map.get("departmentCode"));
			}
		} else {
			System.out.println("No employees exist----------");
		}
	}

	// GET
	private void getEmployee() {
		System.out.println("Testing getEmployee----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandle());
		ResponseEntity<Employee> emp = restTemplate.exchange
				(REST_SERVICE_URI + "getDetailsById/1009", HttpMethod.GET,getSecurityEntity(), Employee.class);
		System.out.println(emp.getBody());
	}

	// POST
	private void createEmployee() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandle());
		Employee emp = new Employee("TestMSD", 0, 1000.0, 103);
		HttpEntity<Object> http = new HttpEntity<Object>(emp, getHeaders());

		ResponseEntity<String> str = restTemplate.exchange(REST_SERVICE_URI + "addEmp", HttpMethod.POST, http,String.class);
		System.out.println("String Returned : " + str.getBody());
	}

	// PUT
	private void updateEmployee() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandle());
		Employee emp = new Employee("UpdateMSD", 1002, 1000.0, 103);
		HttpEntity<Object> http = new HttpEntity<Object>(emp, getHeaders());
		ResponseEntity<Employee> res = restTemplate.exchange(REST_SERVICE_URI + "updateEmp", HttpMethod.PUT, http,Employee.class);
		System.out.println(res.getBody());
	}

	// DELETE
	private void deleteUser() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandle());
		ResponseEntity<Employee> emp = restTemplate.exchange(REST_SERVICE_URI + "deleteEmp/1004", HttpMethod.DELETE,getSecurityEntity(), Employee.class);
		System.out.println(emp.getBody());
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RestTemplateConsumer.class, args);
		RestTemplateConsumer consumer1 = applicationContext.getBean(RestTemplateConsumer.class, "restTemplateConsumer");
		try {
			//consumer1.listAllEmployee();
			consumer1.getEmployee();
			//consumer1.createEmployee();
			//consumer1.updateEmployee();
			//consumer1.deleteUser();
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		applicationContext.close();
	}
}