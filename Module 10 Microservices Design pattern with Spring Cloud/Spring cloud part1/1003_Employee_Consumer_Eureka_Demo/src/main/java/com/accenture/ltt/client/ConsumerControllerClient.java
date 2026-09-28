package com.accenture.ltt.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.ltt.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ConsumerControllerClient {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	//public String REST_SERVICE_URI = "http://localhost:7091/emp/controller/";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "emp/controller/getDetailsClient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployee(){
		
		List<ServiceInstance> instances = discoveryClient.getInstances("cst-employee-producer");
		ServiceInstance serviceInstance = instances.get(0); // IPs, Port  
		String baseUrl = serviceInstance.getUri().toString();// http://ip:port/
		baseUrl = baseUrl + "/emp/controller/getDetails";
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> employeeMapRespEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, null,List.class); 
		
		List<LinkedHashMap<String, Object>>  employeeMap = employeeMapRespEntity.getBody();
		ObjectMapper mapper =  new ObjectMapper();
		Collection<Employee> list  = new ArrayList<Employee>();
		if (employeeMap != null) {
			for (LinkedHashMap<String, Object> map : employeeMap) {
				//Map object should be converted to Employee type 
				Employee emp=mapper.convertValue(map, Employee.class);
				list.add(emp);
			}
		}
		return new ResponseEntity<Collection<Employee>>(list,employeeMapRespEntity.getStatusCode());
	}
}